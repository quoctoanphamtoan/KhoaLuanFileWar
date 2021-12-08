package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.*;
import com.solienlac.khoaluan.web.common.dto.param.CheckAuthParam;
import com.solienlac.khoaluan.web.common.dto.param.DangKiParam;
import com.solienlac.khoaluan.web.common.dto.param.PutImgDetail;
import com.solienlac.khoaluan.web.common.dto.param.PutMatKhau;
import com.solienlac.khoaluan.web.domain.GiangVien;
import com.solienlac.khoaluan.web.domain.PhuHuynh;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.domain.TaiKhoan;
import com.solienlac.khoaluan.web.domain.common.Role;
import com.solienlac.khoaluan.web.repository.GiangVienRepository;
import com.solienlac.khoaluan.web.repository.PhuHuynhRepository;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.repository.TaiKhoanRepository;
import com.solienlac.khoaluan.web.service.TaiKhoanService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@Log4j2
@RequiredArgsConstructor
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private final TaiKhoanRepository taiKhoanRepository;
    private final SinhVienRepository sinhVienRepository;
    private final GiangVienRepository giangVienRepository;
    private final PhuHuynhRepository phuHuynhRepository;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final AmazonClient amazonClient;

    @Override
    public List<TaiKhoan> getAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public TaiKhoanDangNhapResponse userLogin(TaiKhoanDangNhap taiKhoanDangNhap) {
        System.out.println(taiKhoanDangNhap.getTenDangNhap());
        System.out.println(taiKhoanDangNhap.getMatKhau());
        TaiKhoanDangNhapResponse taiKhoanDangNhapResponse = new TaiKhoanDangNhapResponse();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(taiKhoanDangNhap.getTenDangNhap(), taiKhoanDangNhap.getMatKhau()));

        // Create token
        Date now = new Date();
        String token = Jwts.builder()
                .setSubject(taiKhoanDangNhap.getTenDangNhap())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 86400000L))
                .signWith(SignatureAlgorithm.HS512, "ABC_EGH")
                .compact();
        taiKhoanDangNhapResponse.setToken(token);
        /////////////////////
        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(taiKhoanDangNhap.getTenDangNhap());
        if (taiKhoan.getRole()== Role.SINH_VIEN){
            SinhVien sv=  sinhVienRepository.findByMaSinhvVien(taiKhoanDangNhap.getTenDangNhap());
            taiKhoanDangNhapResponse.setRole(Role.SINH_VIEN);
            taiKhoanDangNhapResponse.setThongTin(new ThongTinSinhVienDto(sv));
        }
        if(taiKhoan.getRole()==Role.GIANG_VIEN){
            GiangVien gv = giangVienRepository.findByMaGiangVien(taiKhoanDangNhap.getTenDangNhap());
            taiKhoanDangNhapResponse.setRole(Role.GIANG_VIEN);

            taiKhoanDangNhapResponse.setThongTin(new ThongTinGiangVienDto(gv));
        }
        if (taiKhoan.getRole()==Role.PHU_HUYNH){
            PhuHuynh ph = phuHuynhRepository.findBySoDienThoai(taiKhoanDangNhap.getTenDangNhap());
            ph.setTaiKhoan(null);
            ph.setSinhVienList(null);
            taiKhoanDangNhapResponse.setRole(Role.PHU_HUYNH);
            taiKhoanDangNhapResponse.setThongTin(ph);
        }
        return taiKhoanDangNhapResponse;
    }

/*
* thong tin dang ki {
* -ho ten
* -so dien thoai
* -email
* -role
* -dia chi
* -gioi tinh
* -
* }
*
* */

    @Override
    @Transactional
    public Integer dangKi(DangKiParam thongTin) {
        String id = UUID.randomUUID().toString();
        String role = thongTin.getRole().toString();
        String tenDangNhap  =  "";
        if (role.equalsIgnoreCase(Role.SINH_VIEN.toString())){
            tenDangNhap= "sv"+ id.substring(0,4);
        }
        if (role.equalsIgnoreCase(Role.PHU_HUYNH.toString())){
            tenDangNhap = thongTin.getSoDT();
        }
        if (role.equalsIgnoreCase(Role.GIANG_VIEN.toString())){
            tenDangNhap = "gv" + id.substring(0,4);
        }

        String hashed = BCrypt.hashpw(String.valueOf(123), BCrypt.gensalt());
        TaiKhoan taiKhoan = new TaiKhoan(null,tenDangNhap,thongTin.getRole(),hashed);
        TaiKhoan taiKhoanResult= taiKhoanRepository.save(taiKhoan);

        if (role.equalsIgnoreCase(Role.SINH_VIEN.toString())){
            SinhVien sinhVien = new SinhVien(tenDangNhap,
                    thongTin.getHoTen(), thongTin.getDiaChi(),thongTin.getSoDT(),thongTin.isGioiTinh(),thongTin.getEmail(),taiKhoan);
            sinhVienRepository.save(sinhVien);
        }
        if (role.equalsIgnoreCase(Role.PHU_HUYNH.toString())){
            PhuHuynh phuHuynh = new PhuHuynh(thongTin.getHoTen(), thongTin.getDiaChi(),
                    thongTin.getSoDT(), thongTin.getEmail(), thongTin.isGioiTinh(),taiKhoan);
            PhuHuynh phuHuynhRs= phuHuynhRepository.save(phuHuynh);
            SinhVien sinhVienCon = sinhVienRepository.findById(thongTin.getIdSinhVienCon()).orElse(null);
            sinhVienCon.setPhuHuynh(phuHuynhRs);
        }
        if (role.equalsIgnoreCase(Role.GIANG_VIEN.toString())){
            GiangVien giangVien = new GiangVien(taiKhoanResult.getId(),tenDangNhap,thongTin.getHoTen(),
                    thongTin.getDiaChi(), thongTin.getSoDT(), thongTin.getEmail(), thongTin.isGioiTinh(),taiKhoan);
            giangVienRepository.save(giangVien);
        }


        return  taiKhoanResult.getId();
    }

    @Override
    public CheckAuthResponse checkAuth(CheckAuthParam checkAuthParam) {
        String token = checkAuthParam.getToken();
        String tenDangNhap = null;
        try {
            tenDangNhap = Jwts.parser().setSigningKey("ABC_EGH").parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e) {
            if (e instanceof ExpiredJwtException) {
                 throw new IllegalArgumentException("none");
            }

        }

        if (tenDangNhap==null){
            return new CheckAuthResponse(null,false);
        }

        TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(tenDangNhap);
        return new CheckAuthResponse(taiKhoan.getRole(),true);
    }

    @Override
    @Transactional
    public Integer doiMatKhau(PutMatKhau putMatKhau) {
        if(putMatKhau.getRole().toString().equalsIgnoreCase(Role.SINH_VIEN.toString())){
            SinhVien sinhVien = sinhVienRepository.findById(putMatKhau.getId())
                    .orElseThrow(() -> new IllegalArgumentException("id not found!"));
            if(!BCrypt.checkpw(putMatKhau.getPassword(),sinhVien.getTaiKhoan().getMatKhau())){
                throw new IllegalArgumentException("password error!");
            }
            if (!putMatKhau.getNewPassword().equalsIgnoreCase(putMatKhau.getConfirmPassword())){
                throw new IllegalArgumentException("password khong gioong!");
            }
            String has = BCrypt.hashpw(putMatKhau.getNewPassword(),BCrypt.gensalt());
            sinhVien.getTaiKhoan().setMatKhau(has);
            return 1;
        }



        return -1;
    }

    @Override
    @Transactional
    public String uploadImgUrl(Integer id, MultipartFile file) {
        String urlImg =  amazonClient.uploadFile(file);
        SinhVien sinhVien = sinhVienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id not found!"));
        sinhVien.setImgUrl(urlImg);
        return urlImg;
    }

}
