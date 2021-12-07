package com.solienlac.khoaluan.web.repository;

import com.solienlac.khoaluan.web.domain.CanhBao;

import java.util.List;

public interface CanhBaoCustomRepository {
    List<CanhBao> listCanhBaoSinhVien(Integer id,Integer idGiangVien);
}
