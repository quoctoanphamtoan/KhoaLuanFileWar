package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.DonXinNghiHoc;
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

    public DonXinNghiHocDto(DonXinNghiHoc donXinNghiHoc){
        this.idDonXinNghiHoc = donXinNghiHoc.getId();
        this.idSinhVien=donXinNghiHoc.getSinhVien().getId();
        this.tenSinhVien=donXinNghiHoc.getSinhVien().getHoTen();
        this.tenLopHocPhan =donXinNghiHoc.getLopHocPhan().getTenLopHP();
        this.ngayNghi = donXinNghiHoc.getNgayNghi();
        this.ngayTao=donXinNghiHoc.getNgayTao();
        this.trangThai=donXinNghiHoc.getTrangThai();
        this.noiDung=donXinNghiHoc.getNoiDung();
    }
}
