package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.GiangVien;
import com.solienlac.khoaluan.web.domain.SinhVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThongTinGiangVienDto {
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
    private Integer id;
    private String maSinhVien;
    private String chuyenNganh;
    private String hoTen;
    private boolean gioiTinh;
    private String email;
    private String soDT;
    private String diaChi;
    private String imgUrl;
    public ThongTinGiangVienDto(GiangVien giangVien){
        this.id = giangVien.getId();
        this.maSinhVien = giangVien.getMaGiangVien();
        this.chuyenNganh = giangVien.getChuyenNganh();
        this.hoTen = giangVien.getHoTen();
        this.gioiTinh = giangVien.isGioiTinh();
        this.email = giangVien.getEmail();
        this.soDT = giangVien.getSoDienThoai();
        this.diaChi= giangVien.getDiaChi();
        this.imgUrl = giangVien.getImgUrl();

    }


}
