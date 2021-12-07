package com.solienlac.khoaluan.web.domain;

import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "canhbao")
@Getter
@NoArgsConstructor
public class CanhBao extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tieuDe")
    private String tieuDe;

    @Column(name = "noiDung")
    private String noiDung;

    private boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "idGiangVien")
    private GiangVien idGiangVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSinhVien")
    private SinhVien idSinhVien;


    public CanhBao(String tieuDe,String noiDung, GiangVien idGiangVien, SinhVien idSinhVien) {
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.idGiangVien = idGiangVien;
        this.idSinhVien = idSinhVien;
    }
}
