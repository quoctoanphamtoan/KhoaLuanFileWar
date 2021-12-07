package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.ThongBao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThongBaoCustomRepository {
    Page<ThongBao> listThongBao(Pageable pageable,Integer idSinhVien);
    Page<ThongBao> thongBaoLopSinhVien(Pageable pageable,Integer idGiangVien,Integer idLop);
}
