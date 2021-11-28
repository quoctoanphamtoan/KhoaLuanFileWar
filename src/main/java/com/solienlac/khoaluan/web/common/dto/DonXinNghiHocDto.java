package com.solienlac.khoaluan.web.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*
id sinh vien
ten sinh vien
ten lop hoc phan
noi dung
ngay nghi
ngay tao
trang thai


 */
public class DonXinNghiHocDto {
    private Integer idDonXinNghiHoc;
    private Integer idSinhVien;
    private String tenSinhVien;
    private String tenLopHocPhan;
    private Date ngayNghi;
    private Date ngayTao;
    private Boolean trangThai;
    private String noiDung;
}
