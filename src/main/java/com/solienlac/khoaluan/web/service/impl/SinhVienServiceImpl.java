package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.ThongTinSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.param.PutSinhVienParam;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.SinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SinhVienServiceImpl implements SinhVienService {
    private final SinhVienRepository sinhVienRepository;
    @Override
    public ThongTinSinhVienDto xemThongTin(Integer id) {
        SinhVien sinhVien = sinhVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found"));

        return new ThongTinSinhVienDto(sinhVien);
    }

    @Override
    @Transactional
    public Integer chinhSuaSinhVien(Integer id,PutSinhVienParam putSinhVienParam) {
        SinhVien sinhVien = sinhVienRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found"));
        sinhVien.chinhSua(putSinhVienParam);
        return id;
    }
}
