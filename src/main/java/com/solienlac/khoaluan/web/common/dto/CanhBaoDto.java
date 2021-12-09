package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.CanhBao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CanhBaoDto {

    private Integer id;
    private Integer idSinhVien;
    private String tenSinhVien;
    private String noiDung;
    private String tieuDe;
    private Date ngayTao;
    private boolean trangThai;


    public CanhBaoDto(CanhBao canhBao){
        this.id=canhBao.getId();
        this.noiDung= canhBao.getNoiDung();
        this.idSinhVien = canhBao.getIdSinhVien().getId();
        this.tenSinhVien = canhBao.getIdSinhVien().getHoTen();
        this.tieuDe = canhBao.getTieuDe();
        this.ngayTao = canhBao.getNgayTao();
        this.trangThai = canhBao.isTrangThai();
    }

}
