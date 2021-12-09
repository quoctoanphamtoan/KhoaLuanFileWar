package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.CanhBaoDto;
import com.solienlac.khoaluan.web.repository.CanhBaoCustomRepository;
import com.solienlac.khoaluan.web.service.CanhBaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CanhBaoServiceImpl implements CanhBaoService {
    private final CanhBaoCustomRepository canhBaoCustomRepository;
    @Override
    public List<CanhBaoDto> listCanhBao(Integer idSinhVien,Integer idGiangVien) {
        return canhBaoCustomRepository.listCanhBaoSinhVien(idSinhVien,idGiangVien).stream().map(canhBao -> new CanhBaoDto(canhBao)).collect(Collectors.toList());
    }
}
