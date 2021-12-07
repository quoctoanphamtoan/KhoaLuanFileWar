package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.ThongBao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ThongBaoLopOfGiangVien {
    private Integer id;
    private String tieuDe;
    private Date ngayTao;
    private String noiDung;
    private boolean hienThi;
    private boolean trangThai;
    public ThongBaoLopOfGiangVien(ThongBao thongBao){
        this.id= thongBao.getId();
        this.tieuDe=thongBao.getTieuDe();
        this.ngayTao = thongBao.getNgayTao();
        this.noiDung=thongBao.getNoiDung();
        this.hienThi = thongBao.isHienThi();
        this.trangThai = thongBao.isTrangThai();
    }
}
