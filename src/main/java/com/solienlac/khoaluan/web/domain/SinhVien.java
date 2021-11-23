package com.solienlac.khoaluan.web.domain;


import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SinhVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien  extends AbstractEntity {
    @Id
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

    @OneToOne(mappedBy = "sinhVien",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TaiKhoan taiKhoan;

    @OneToMany(mappedBy = "idSinhVien")
    private List<CanhBao> canhBaoList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPhuHuynh")
    private PhuHuynh phuHuynh;

    @ManyToOne
    @JoinColumn(name = "idChuyenNganh")
    private ChuyenNganh chuyenNganh;

    public SinhVien(Integer id, String maSinhvVien, String hoTen, String diaChi, String soDienThoai, Boolean gioiTinh, String email) {
        this.id = id;
        this.maSinhvVien = maSinhvVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.email = email;
    }
}
