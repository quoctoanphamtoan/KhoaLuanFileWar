package com.solienlac.khoaluan.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "diem_sinhvien_monhoc")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BangDiem_SinhVien_MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double diemCK;
    private double diemGK;

    private double diemTK1;
    private double diemTK2;
    private double diemTK3;
    private double diemTBC;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMonHoc")
    private MonHoc monHoc;


}
