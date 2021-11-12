package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinhVienRepository extends JpaRepository<SinhVien,String> {
    SinhVien findByMaSinhvVien(String maSinhVien);
}
