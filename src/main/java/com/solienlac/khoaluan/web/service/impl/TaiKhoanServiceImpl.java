package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhap;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhapResponse;
import com.solienlac.khoaluan.web.common.exception.BadRequestException;
import com.solienlac.khoaluan.web.common.exception.ResourceNotFoundException;
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
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private final TaiKhoanRepository taiKhoanRepository;
    private final SinhVienRepository sinhVienRepository;
    private final GiangVienRepository giangVienRepository;
    private final PhuHuynhRepository phuHuynhRepository;
    AuthenticationManager authenticationManager;
    public TaiKhoanServiceImpl(AuthenticationManager authenticationManager, TaiKhoanRepository taiKhoanRepository, SinhVienRepository sinhVienRepository, GiangVienRepository giangVienRepository, PhuHuynhRepository phuHuynhRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
        this.authenticationManager =authenticationManager;
        this.sinhVienRepository =sinhVienRepository;
        this.giangVienRepository = giangVienRepository;
        this.phuHuynhRepository = phuHuynhRepository;
    }

    @Override
    public List<TaiKhoan> getAll() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public TaiKhoanDangNhapResponse userLogin(TaiKhoanDangNhap taiKhoanDangNhap) {
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
            sv.setTaiKhoan(null);
            taiKhoanDangNhapResponse.setRole(Role.SINH_VIEN);
            taiKhoanDangNhapResponse.setThongTin(sv);
        }
        if(taiKhoan.getRole()==Role.GIANG_VIEN){
            GiangVien gv = giangVienRepository.findByMaGiangVien(taiKhoanDangNhap.getTenDangNhap());
            gv.setTaiKhoan(null);
            taiKhoanDangNhapResponse.setRole(Role.GIANG_VIEN);
            taiKhoanDangNhapResponse.setThongTin(gv);
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



    @Override
    public Integer dangKi(HashMap<String,Object> thongTin) {
        String id = UUID.randomUUID().toString();
        String role = thongTin.get("ROLE").toString();
        String hashed = BCrypt.hashpw(String.valueOf(123), BCrypt.gensalt());
       if (role.equalsIgnoreCase(Role.SINH_VIEN.toString())){
            String tenDangNhap = "sv"+id.substring(0,4);
            TaiKhoan taiKhoan = new TaiKhoan();
            taiKhoan.setId(id);
            taiKhoan.setMatKhau(hashed);
            taiKhoan.setTenDangNhap(tenDangNhap);
            taiKhoan.setRole(Role.SINH_VIEN);
            taiKhoanRepository.save(taiKhoan);

            //////////////
            SinhVien sinhVien = new SinhVien();
            sinhVien.setId(id);
            sinhVien.setMaSinhvVien(tenDangNhap);
            sinhVien.setHoTen(thongTin.get("HO_TEN").toString());
            sinhVien.setDiaChi(thongTin.get("DIA_CHI").toString());
            sinhVien.setSoDienThoai(thongTin.get("SDT").toString());
            sinhVien.setGioiTinh(true?thongTin.get("GIOI_TINH").toString().equalsIgnoreCase("NAM"):false);
            sinhVienRepository.save(sinhVien);
            return 1;
       }else if(thongTin.get("ROLE").toString().equalsIgnoreCase(Role.GIANG_VIEN.toString())){
           String tenDangNhap = "gv"+id.substring(0,4);
           TaiKhoan taiKhoan = new TaiKhoan();
           taiKhoan.setId(id);
           taiKhoan.setMatKhau(hashed);
           taiKhoan.setTenDangNhap(tenDangNhap);
           taiKhoan.setRole(Role.GIANG_VIEN);
           taiKhoanRepository.save(taiKhoan);
           GiangVien giangVien = new GiangVien();

           giangVien.setId(id);
           giangVien.setMaGiangVien(tenDangNhap);
           giangVien.setHoTen(thongTin.get("HO_TEN").toString());
           giangVien.setDiaChi(thongTin.get("DIA_CHI").toString());
           giangVien.setSoDienThoai(thongTin.get("SDT").toString());
           giangVien.setGioiTinh(true?thongTin.get("GIOI_TINH").toString().equalsIgnoreCase("NAM"):
                   false);
           giangVienRepository.save(giangVien);
           return 1;


       }else if(thongTin.get("ROLE").toString().equalsIgnoreCase(Role.PHU_HUYNH.toString())){
           String tenDangNhap = thongTin.get("SDT").toString().trim();
           if(thongTin.get("SDT").toString().equalsIgnoreCase(taiKhoanRepository.findByTenDangNhap(thongTin.get("SDT").toString()).getTenDangNhap())){
               throw new BadRequestException("Số điện thoại đã được đăng kí !");
           }
           TaiKhoan taiKhoan = new TaiKhoan();
           taiKhoan.setId(id);
           taiKhoan.setMatKhau(hashed);
           taiKhoan.setTenDangNhap(tenDangNhap);
           taiKhoan.setRole(Role.PHU_HUYNH);
           taiKhoanRepository.save(taiKhoan);

           SinhVien sinhVienCon = sinhVienRepository.findByMaSinhvVien(thongTin.get("SINH_VIEN").toString());
            if (sinhVienCon==null){
                throw new ResourceNotFoundException("Sinh viên không tồn tại !");
            }
           PhuHuynh phuHuynh = new PhuHuynh();
           phuHuynh.setId(id);
           phuHuynh.setHoTen(thongTin.get("HO_TEN").toString());
           phuHuynh.setDiaChi(thongTin.get("DIA_CHI").toString());
           phuHuynh.setSoDienThoai(thongTin.get("SDT").toString());
           phuHuynh.setGioiTinh(true?thongTin.get("GIOI_TINH").toString().equalsIgnoreCase("NAM"):false);
           PhuHuynh phuHuynhResult= phuHuynhRepository.save(phuHuynh);
           sinhVienCon.setPhuHuynh(phuHuynhResult);
           sinhVienRepository.save(sinhVienCon);
           return 1;
       }
        return 0;
    }

}
