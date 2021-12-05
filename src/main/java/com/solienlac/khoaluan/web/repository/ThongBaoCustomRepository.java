package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.ThongBao;
import com.solienlac.khoaluan.web.domain.ThongBao_Lop;
import com.solienlac.khoaluan.web.domain.ThongBao_LopHocPhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThongBaoCustomRepository {
    Page<ThongBao_Lop> listThongBaoLopOfSinhVien(Pageable pageable, Integer idLop);
    Page<ThongBao_LopHocPhan> listThongBaoLopHocPhanOfSinhVien(Pageable pageable, Integer idLopHocPhan);
    Page<ThongBao> listThongBao(Pageable pageable,Integer idSinhVien);
}
