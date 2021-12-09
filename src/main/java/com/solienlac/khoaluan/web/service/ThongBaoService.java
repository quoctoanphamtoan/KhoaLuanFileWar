package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.GetThongBaoLopOfGiangVien;
import com.solienlac.khoaluan.web.common.dto.GetThongBaoSinhVien;
import com.solienlac.khoaluan.web.common.dto.param.PostThongBaoLop;
import org.springframework.data.domain.Pageable;

public interface ThongBaoService {
    GetThongBaoSinhVien getThongBaoSinhVien(Pageable pageable, Integer idSinhVien);
    GetThongBaoLopOfGiangVien getThongBaoLopOfGiangVien(Pageable pageable,Integer idLop,Integer idGiangVien);
    Integer themThongBaoLop(Integer idGiangVien,Integer idLop, PostThongBaoLop postThongBaoLop);
    Integer chinhSuaThongBaoLop(Integer idThongBao, PostThongBaoLop postThongBaoLop);

    Integer chinhSuaHienThiThongBaoLop(Integer idThongBao);
}
