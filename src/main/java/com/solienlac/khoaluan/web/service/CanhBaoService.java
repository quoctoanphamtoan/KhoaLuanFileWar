package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.CanhBaoDto;

import java.util.List;

public interface CanhBaoService {
    List<CanhBaoDto> listCanhBao(Integer idSinhVien,Integer idGiangVien);
}
