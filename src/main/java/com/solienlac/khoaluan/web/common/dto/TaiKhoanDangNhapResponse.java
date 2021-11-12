package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.common.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanDangNhapResponse {
    private String token;
    private Object thongTin;
    private Role role;
}
