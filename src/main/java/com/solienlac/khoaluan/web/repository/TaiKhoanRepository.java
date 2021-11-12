package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,Integer> {
    TaiKhoan findByTenDangNhap(String tenDangNhap);
}
