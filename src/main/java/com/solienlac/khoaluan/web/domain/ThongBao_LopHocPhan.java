package com.solienlac.khoaluan.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "thongbao_lophocphan")
@Getter
@Setter
@NoArgsConstructor
public class ThongBao_LopHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idThongBao")
    private ThongBao thongBao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLopHocPhan")
    private LopHocPhan lopHocPhan;

}
