package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.DonXinNghiHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DonXinNghiHocCustomRepository {
    Page<DonXinNghiHoc> listDonXinNghiHoc(Pageable pageable, Integer idGiangVien);
}
