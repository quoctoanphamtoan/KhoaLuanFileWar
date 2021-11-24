package com.solienlac.khoaluan.web.common.dto.param;

import com.solienlac.khoaluan.web.domain.common.Role;
import lombok.Data;

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
@Data
public class DangKiParam {
    private String hoTen;
    private String soDT;
    private String email;
    private String diaChi;
    private boolean gioiTinh;
    private Role role;
    private String chuyenNganh;
    private Integer idSinhVienCon;

}
