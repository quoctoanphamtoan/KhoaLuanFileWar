package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.GetDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import org.springframework.data.domain.Pageable;


public interface DonXinNghiHocService {
    Integer xinNghiHoc(Integer idSinhVien, Integer idLopHocPhan, PostDonXinNghiHoc postDonXinNghiHoc);
    Integer duyetDonXinNghiHoc(Integer idGiangVien,Integer idDonXinNghiHoc);
    GetDonXinNghiHoc getDonXinNghiHoc(Pageable pageable, Integer idGiangVien);
}
