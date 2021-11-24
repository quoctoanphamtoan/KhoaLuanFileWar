package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.Lop;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LopDto {
    private String tenLop;
    private String tenChuyenNganh;
    private Integer siSo;

    public LopDto(Lop lop) {
        this.tenLop = lop.getTenLop();
        this.tenChuyenNganh = lop.getChuyenNganh();
        this.siSo = lop.getSiSo();
    }

}