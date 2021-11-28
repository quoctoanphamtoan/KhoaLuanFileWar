package com.solienlac.khoaluan.web.domain;


import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import com.solienlac.khoaluan.web.domain.common.TrangThaiSinhVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sinhvien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "maSinhVien")
    private String maSinhvVien;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "email")
    private String email;

    @Column(name = "trangThai")
    @Enumerated(EnumType.STRING)
    private TrangThaiSinhVien trangThai = TrangThaiSinhVien.DANG_HOC;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTaiKhoan")
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "idSinhVien")
    private List<CanhBao> canhBaoList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPhuHuynh")
    private PhuHuynh phuHuynh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idLop")
    private Lop lop;


    @OneToMany(mappedBy = "sinhVien")
    private List<DonXinNghiHoc> donXinNghiHocs= new ArrayList<>();

    public SinhVien(String maSinhvVien, String hoTen, String diaChi, String soDienThoai, Boolean gioiTinh, String email,TaiKhoan taiKhoan) {
        this.maSinhvVien = maSinhvVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.taiKhoan = taiKhoan;
    }
}
