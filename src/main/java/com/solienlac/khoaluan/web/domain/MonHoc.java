package com.solienlac.khoaluan.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "monhoc")
@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tenMonHoc;
    private String tenChuyenNganh;

    @OneToMany(mappedBy = "monHoc")
    private List<LopHocPhan> lopHocPhans  = new ArrayList<>();

    @OneToMany(mappedBy = "monHoc")
    private List<BangDiem_SinhVien_MonHoc> bangDiem_sinhVien_monHocs = new ArrayList<>();


}
