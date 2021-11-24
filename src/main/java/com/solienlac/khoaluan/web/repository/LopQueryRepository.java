package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.common.dto.LopDto;
import com.solienlac.khoaluan.web.domain.Lop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LopQueryRepository {
    Page<Lop> getLop(Pageable pageable, Integer idGiangVien);
}
