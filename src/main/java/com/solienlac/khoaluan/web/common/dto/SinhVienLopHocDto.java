package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.domain.common.TrangThaiSinhVien;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SinhVienLopHocDto {
    private Integer id;
    private String hoTen;
    private boolean isGioiTinh;
    private String email;
    private String soDT;
    private TrangThaiSinhVien trangThaiSinhVien;
    private String soDTPhuHuynh;

    public SinhVienLopHocDto(SinhVien sinhVien) {
        this.id = sinhVien.getId();
        this.hoTen = sinhVien.getHoTen();
        this.isGioiTinh = sinhVien.isGioiTinh();
        this.email = sinhVien.getEmail();
        this.trangThaiSinhVien = sinhVien.getTrangThai();
        this.soDT = sinhVien.getSoDienThoai();
//        this.soDTPhuHuynh = sinhVien.getPhuHuynh().getHoTen();

    }
}
