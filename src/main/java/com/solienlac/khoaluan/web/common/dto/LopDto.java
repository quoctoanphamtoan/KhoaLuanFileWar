package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.Lop;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LopDto {
    private Integer id;
    private String tenLop;
    private String tenChuyenNganh;
    private Integer siSo;
    private String khoaHoc;
    public LopDto(Lop lop) {
        this.id = lop.getId();
        this.tenLop = lop.getTenLop();
        this.tenChuyenNganh = lop.getChuyenNganh();
        this.siSo = lop.getSiSo();
        this.khoaHoc = lop.getKhoaHoc();
    }

}