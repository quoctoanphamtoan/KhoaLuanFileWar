package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.GetThongBaoSinhVien;
import org.springframework.data.domain.Pageable;

public interface ThongBaoService {
    GetThongBaoSinhVien getThongBaoSinhVien(Pageable pageable, Integer idSinhVien);
}
