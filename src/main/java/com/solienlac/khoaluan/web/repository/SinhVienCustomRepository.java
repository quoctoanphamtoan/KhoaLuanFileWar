package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.SinhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SinhVienCustomRepository {
    Page<SinhVien> listSinhVienLopHoc(Pageable pageable,Integer idLopHoc);
}
