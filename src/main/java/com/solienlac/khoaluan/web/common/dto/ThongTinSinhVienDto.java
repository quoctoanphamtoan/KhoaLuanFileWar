package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.SinhVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThongTinSinhVienDto {
    /*

    maSinhVien
    chuyen nganh
    ho va ten
    gioi tinh
    lop
    email
    so dien thoai
    dia chi
    hinh anh


     */
    private String maSinhVien;
    private String chuyenNganh;
    private String hoTen;
    private boolean gioiTinh;
    private String tenLop;
    private String email;
    private String soDT;
    private String diaChi;
    private String imgUrl;
    public ThongTinSinhVienDto(SinhVien sinhVien){
        this.maSinhVien = sinhVien.getMaSinhvVien();
        this.chuyenNganh = sinhVien.getChuyenNganh();
        this.hoTen = sinhVien.getHoTen();
        this.gioiTinh = sinhVien.isGioiTinh();
        this.tenLop = sinhVien.getLop().getTenLop();
        this.email = sinhVien.getEmail();
        this.soDT = sinhVien.getSoDienThoai();
        this.diaChi= sinhVien.getDiaChi();
        this.imgUrl =sinhVien.getImgUrl();

    }


}
