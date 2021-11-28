package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;

public interface DonXinNghiHocService {
    Integer xinNghiHoc(Integer idSinhVien, Integer idLopHocPhan, PostDonXinNghiHoc postDonXinNghiHoc);
    Integer duyetDonXinNghiHoc(Integer idGiangVien,Integer idDonXinNghiHoc);
}
