package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.GetLop;
import com.solienlac.khoaluan.web.common.dto.LopDto;
import com.solienlac.khoaluan.web.common.page.PaginationMeta;
import com.solienlac.khoaluan.web.domain.Lop;
import com.solienlac.khoaluan.web.repository.GiangVienRepository;
import com.solienlac.khoaluan.web.repository.LopQueryRepository;
import com.solienlac.khoaluan.web.service.LopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LopServiceImpl implements LopService {
    private final LopQueryRepository lopQueryRepository;
    private final GiangVienRepository giangVienRepository;

    @Override
    public GetLop getLop(Pageable pageable,Integer idGiangVien) {
        List<LopDto> list = new ArrayList<>();
        Page<Lop> page = lopQueryRepository.getLop(pageable,idGiangVien);
        page.getContent().forEach(lop -> {
            list.add(new LopDto(lop));
        });
        PaginationMeta paginationMeta = PaginationMeta.createPagination(page);
        return new GetLop(list,paginationMeta);
    }
}
