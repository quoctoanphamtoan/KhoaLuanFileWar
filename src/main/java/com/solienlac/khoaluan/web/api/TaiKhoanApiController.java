package com.solienlac.khoaluan.web.api;

import com.solienlac.khoaluan.web.common.dto.CheckAuthResponse;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhap;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhapResponse;
import com.solienlac.khoaluan.web.common.dto.param.CheckAuthParam;
import com.solienlac.khoaluan.web.common.dto.param.DangKiParam;
import com.solienlac.khoaluan.web.common.dto.param.PutMatKhau;
import com.solienlac.khoaluan.web.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/taikhoan")
public class TaiKhoanApiController {
    private final TaiKhoanService taiKhoanService;

    @PostMapping("/dangnhap")
    public  ResponseEntity<TaiKhoanDangNhapResponse> dangNhap(@RequestBody TaiKhoanDangNhap taiKhoanDangNhap){
        TaiKhoanDangNhapResponse userLoginResponseDto = taiKhoanService.userLogin(taiKhoanDangNhap);
        return ResponseEntity.ok(userLoginResponseDto);
    }

    @PostMapping("/dangki")
    @ResponseStatus(HttpStatus.CREATED)
    public int dangKi(@RequestBody DangKiParam thongTin){
        return taiKhoanService.dangKi(thongTin);
    }

    @PostMapping("/checkauth")
    @ResponseStatus(HttpStatus.OK)
    public CheckAuthResponse checkAuth(@RequestBody CheckAuthParam checkAuthParam){
        return taiKhoanService.checkAuth(checkAuthParam);
    }

    @PutMapping("/doimatkhau")
    @ResponseStatus(HttpStatus.OK)
    public Integer doiMatKhau(@RequestBody PutMatKhau putMatKhau){
        return taiKhoanService.doiMatKhau(putMatKhau);
    }

}
