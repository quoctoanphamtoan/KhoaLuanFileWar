package com.solienlac.khoaluan.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Lop")
@NoArgsConstructor
@Getter
public class Lop {
    @Id
    private Integer id;
    private String tenLop;


    @ManyToOne
    @JoinColumn(name = "idChuyenNganh")
    private ChuyenNganh chuyenNganh;

    @ManyToOne
    @JoinColumn(name = "idGiangVien")
    private GiangVien giangVien;

}
