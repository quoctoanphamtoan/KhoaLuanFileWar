package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinhVienRepository extends JpaRepository<SinhVien,Integer> {
    SinhVien findByMaSinhvVien(String maSinhVien);
}
