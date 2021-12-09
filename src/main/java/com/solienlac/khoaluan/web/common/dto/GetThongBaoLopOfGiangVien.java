package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.common.page.PaginationMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetThongBaoLopOfGiangVien {
    private List<ThongBaoLopOfGiangVien> thongBaoLopOfGiangViens;
    private PaginationMeta paginationMeta;
}
