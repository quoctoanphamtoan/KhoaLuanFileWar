package com.solienlac.khoaluan.web.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sinhvien_lophocphan")
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien_LopHocPhan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @EmbeddedId
    SinhVien_LopHocPhan_Id sinhVien_lopHocPhan_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idSinhVien")
    @JoinColumn(name = "idSinhVien")
    SinhVien sinhVien;


    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idLopHocPhan")
    @JoinColumn(name = "idLopHocPhan")
    LopHocPhan lopHocPhan;


}
