package com.solienlac.khoaluan.web.repository;


import com.solienlac.khoaluan.web.domain.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiangVienRepository extends JpaRepository<GiangVien,Integer> {
    GiangVien findByMaGiangVien(String maGiangVien);
}
