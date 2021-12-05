package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.GetLop;
import com.solienlac.khoaluan.web.common.dto.GetThongBaoSinhVien;
import com.solienlac.khoaluan.web.common.dto.LopDto;
import com.solienlac.khoaluan.web.common.dto.ThongBaoSinhVienDto;
import com.solienlac.khoaluan.web.common.page.PaginationMeta;
import com.solienlac.khoaluan.web.domain.*;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.repository.ThongBaoCustomRepository;
import com.solienlac.khoaluan.web.service.ThongBaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThongBaoServiceImpl implements ThongBaoService {
    private final ThongBaoCustomRepository thongBaoCustomRepository;
    private final SinhVienRepository sinhVienRepository;
    @Override
    public GetThongBaoSinhVien getThongBaoSinhVien(Pageable pageable, Integer idSinhVien) {
        SinhVien sinhVien = sinhVienRepository.findById(idSinhVien).orElseThrow(() -> new IllegalArgumentException("id not foud"));
        Page<ThongBao> page = thongBaoCustomRepository.listThongBao(pageable,idSinhVien);
        List<ThongBaoSinhVienDto> list = page.getContent().stream().map(thongBao -> new ThongBaoSinhVienDto(thongBao)).collect(Collectors.toList());
        PaginationMeta paginationMeta = PaginationMeta.createPagination(page);
        return new GetThongBaoSinhVien(list,paginationMeta);
    }
}
