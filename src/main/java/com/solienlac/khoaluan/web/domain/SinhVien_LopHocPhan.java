package com.solienlac.khoaluan.web.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sinhvien_lophocphan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SinhVien_LopHocPhan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean trangThai =true;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSinhVien")
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLopHocPhan")
    private LopHocPhan lopHocPhan;


}
