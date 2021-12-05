package com.solienlac.khoaluan.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lophocphan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LopHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenLopHocPhan")
    private String tenLopHP;

    private String thu;
    private String tiet;
    private String hocKi;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGiangVien")
    private GiangVien giangVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMonHoc")
    private MonHoc monHoc;

    @OneToMany(mappedBy = "lopHocPhan")
    private List<DonXinNghiHoc> donXinNghiHocs = new ArrayList<>();

    @OneToMany(mappedBy = "lopHocPhan")
    private List<ThongBao_LopHocPhan> thongBao_lopHocPhans = new ArrayList<>();
    @OneToMany(mappedBy = "lopHocPhan")
    private List<SinhVien_LopHocPhan> sinhVien_lopHocPhans = new ArrayList<>();

}
