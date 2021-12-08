package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.CheckAuthResponse;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhap;
import com.solienlac.khoaluan.web.common.dto.TaiKhoanDangNhapResponse;
import com.solienlac.khoaluan.web.common.dto.param.CheckAuthParam;
import com.solienlac.khoaluan.web.common.dto.param.DangKiParam;
import com.solienlac.khoaluan.web.common.dto.param.PutImgDetail;
import com.solienlac.khoaluan.web.common.dto.param.PutMatKhau;
import com.solienlac.khoaluan.web.domain.TaiKhoan;
import com.solienlac.khoaluan.web.domain.common.Role;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoan> getAll();
    TaiKhoanDangNhapResponse userLogin(TaiKhoanDangNhap taiKhoanDangNhap);
    Integer dangKi(DangKiParam taiKhoan);
    CheckAuthResponse checkAuth(CheckAuthParam checkAuthParam);
    Integer doiMatKhau(PutMatKhau putMatKhau);
    String uploadImgUrl(Integer id, MultipartFile file);
}
