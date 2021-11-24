package com.solienlac.khoaluan.web.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import com.solienlac.khoaluan.web.domain.common.TrangThaiPhuHuynh;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phuhuynh")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhuHuynh  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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


    @Column(name = "trangThai")
    @Enumerated(EnumType.STRING)
    private TrangThaiPhuHuynh trangThai = TrangThaiPhuHuynh.HOAT_DONG;

    @OneToMany(mappedBy = "idSinhVien")
    private List<CanhBao> canhBaoList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTaiKhoan")
    private TaiKhoan taiKhoan;

    @JsonManagedReference
    @OneToMany(mappedBy = "phuHuynh")
    private List<SinhVien> sinhVienList = new ArrayList<>();


    public PhuHuynh(String hoTen, String diaChi, String soDienThoai, String email, Boolean gioiTinh,TaiKhoan taiKhoan) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.taiKhoan = taiKhoan;
    }

}
