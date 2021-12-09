package com.solienlac.khoaluan.web.domain;

import com.solienlac.khoaluan.web.common.dto.param.PostThongBaoLop;
import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "thongbao")
public class ThongBao extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String noiDung;
    private String tieuDe;



    private boolean trangThai;

    private boolean hienThi = true;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGiangVien")
    private GiangVien giangVien;

    @OneToMany(mappedBy = "thongBao")
    private List<ThongBao_LopHocPhan> thongBao_lopHocPhans = new ArrayList<>();

    @OneToMany(mappedBy = "thongBao")
    private List<ThongBao_Lop> thongBao_lops= new ArrayList<>();
    public ThongBao(PostThongBaoLop postThongBaoLop,GiangVien giangVien){
        this.noiDung = postThongBaoLop.getNoiDung();
        this.tieuDe = postThongBaoLop.getTieuDe();
        this.giangVien = giangVien;
    }

    public void chinhSuaThongBaoLop(PostThongBaoLop postThongBaoLop) {
        this.tieuDe=postThongBaoLop.getTieuDe();
        this.noiDung=postThongBaoLop.getNoiDung();
    }

    public void chinhSuaHienThiThongBaoLop() {
        this.hienThi = !this.isHienThi();
    }
}
