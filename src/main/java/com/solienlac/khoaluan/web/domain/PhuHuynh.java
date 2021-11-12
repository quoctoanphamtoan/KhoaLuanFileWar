package com.solienlac.khoaluan.web.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PhuHuynh")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhuHuynh  extends AbstractEntity {
    @Id
    private String id;
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


    @OneToOne(mappedBy = "phuHuynh",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TaiKhoan taiKhoan;

    @JsonManagedReference
    @OneToMany(mappedBy = "phuHuynh")
    private List<SinhVien> sinhVienList = new ArrayList<>();

}
