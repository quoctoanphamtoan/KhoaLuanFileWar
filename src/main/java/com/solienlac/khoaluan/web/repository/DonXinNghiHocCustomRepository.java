package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.DonXinNghiHoc;
import org.springframework.data.domain.Page;

public interface DonXinNghiHocCustomRepository {
    Page<DonXinNghiHoc> listDonXinNghiHoc(Integer idGiangVien);
}
