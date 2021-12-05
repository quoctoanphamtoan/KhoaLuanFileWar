package com.solienlac.khoaluan.web.domain;

import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import com.solienlac.khoaluan.web.domain.common.TrangThaiGiangVien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "giangvien")
public class GiangVien  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean gioiTinh;

    @Column(name = "trangThai")
    @Enumerated(EnumType.STRING)
    private TrangThaiGiangVien trangThai = TrangThaiGiangVien.CONG_TAC;

    @OneToMany(mappedBy = "giangVien")
    private List<Lop> lops;

    private String chuyenNganh;

    private String imgUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTaiKhoan")
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "giangVien")
    private List<ThongBao> thongBaos= new ArrayList<>();

    public GiangVien(Integer id, String maGiangVien, String hoTen, String diaChi,
                     String soDienThoai, String email, Boolean gioiTinh,TaiKhoan taiKhoan) {
        this.id = id;
        this.maGiangVien = maGiangVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.taiKhoan = taiKhoan;
    }
}
