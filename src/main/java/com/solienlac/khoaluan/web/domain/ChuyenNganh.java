package com.solienlac.khoaluan.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ChuyenNganh")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ChuyenNganh {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "tenChuyenNganh")
    private String tenChuyenNgnah;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "chuyenNganh")
    private List<SinhVien> sinhVienList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "chuyenNganh")
    private List<Lop> lops;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "chuyenNganh")
    private List<GiangVien> giangViens;

}
