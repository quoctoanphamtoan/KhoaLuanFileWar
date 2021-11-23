package com.solienlac.khoaluan.web.domain;

import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GiangVien")
public class GiangVien  extends AbstractEntity {
    @Id
    private Integer id;

    @Column(name = "maGiangVien")
    private String maGiangVien;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;


    @OneToOne(mappedBy = "giangVien",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TaiKhoan taiKhoan;


    @ManyToOne
    @JoinColumn(name = "idChuyenNganh")
    private ChuyenNganh chuyenNganh;


    public GiangVien(Integer id, String maGiangVien, String hoTen, String diaChi, String soDienThoai, String email, Boolean gioiTinh) {
        this.id = id;
        this.maGiangVien = maGiangVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
    }
}
