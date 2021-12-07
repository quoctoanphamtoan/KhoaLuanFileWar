package com.solienlac.khoaluan.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "thongbao_lop")
@Getter
@Setter
@NoArgsConstructor
public class ThongBao_Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idThongBao")
    private ThongBao thongBao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLop")
    private Lop lop;

    public ThongBao_Lop(ThongBao thongBao, Lop lop) {
        this.thongBao = thongBao;
        this.lop = lop;
    }
}
