package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.ThongBao;
import com.solienlac.khoaluan.web.domain.ThongBao_Lop;
import com.solienlac.khoaluan.web.domain.ThongBao_LopHocPhan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongBaoSinhVienDto {
    private Integer id;
    private String tieuDe;
    private String thongBaoType;
    private String noiDung;
    private Date ngayTao;
    private String tenGiangVien;

    public ThongBaoSinhVienDto(ThongBao_Lop thongBao_lop){
        this.id = thongBao_lop.getThongBao().getId();
        this.tieuDe = thongBao_lop.getThongBao().getTieuDe();
        this.thongBaoType = "TB_LOP";
        this.noiDung = thongBao_lop.getThongBao().getNoiDung();
        this.ngayTao = thongBao_lop.getThongBao().getNgayTao();
        this.tenGiangVien = thongBao_lop.getThongBao().getGiangVien().getHoTen();
    }
    public ThongBaoSinhVienDto(ThongBao_LopHocPhan thongBao_lopHocPhan){
        this.id = thongBao_lopHocPhan.getThongBao().getId();
        this.tieuDe = thongBao_lopHocPhan.getThongBao().getTieuDe();
        this.thongBaoType = "TB_LOP_HOCPHAN";
        this.noiDung = thongBao_lopHocPhan.getThongBao().getNoiDung();
        this.ngayTao = thongBao_lopHocPhan.getThongBao().getNgayTao();
        this.tenGiangVien = thongBao_lopHocPhan.getThongBao().getGiangVien().getHoTen();
    }
    public ThongBaoSinhVienDto(ThongBao thongBao){
        this.id = thongBao.getId();
        this.ngayTao = thongBao.getNgayTao();
        this.tenGiangVien = thongBao.getGiangVien().getHoTen();
        this.noiDung = thongBao.getNoiDung();
        this.tieuDe = thongBao.getTieuDe();

        if (thongBao.getThongBao_lops().size()>0)this.thongBaoType="TB_LOP";
        if (thongBao.getThongBao_lopHocPhans().size()>0)this.thongBaoType="TB_LOP_HP";
    }
}
