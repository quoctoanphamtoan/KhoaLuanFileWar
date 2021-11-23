package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.PhuHuynh;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhuHuynhRepository extends JpaRepository<PhuHuynh,Integer> {
    PhuHuynh findBySoDienThoai(String sdt);
}
