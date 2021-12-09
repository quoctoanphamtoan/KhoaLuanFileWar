package com.solienlac.khoaluan.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lop")
@NoArgsConstructor
@Getter
public class Lop {
    @Id
    private Integer id;
    private String tenLop;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lop")
    private List<SinhVien> sinhViens = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGiangVien")
    private GiangVien giangVien;

    @Column(name = "chuyenNganh")
    private String chuyenNganh;

    private String khoaHoc;

    @OneToMany(mappedBy = "thongBao")
    private List<ThongBao_LopHocPhan> thongBao_lopHocPhans = new ArrayList<>();
    public Integer getSiSo(){
        return this.sinhViens.size();
    }
}
