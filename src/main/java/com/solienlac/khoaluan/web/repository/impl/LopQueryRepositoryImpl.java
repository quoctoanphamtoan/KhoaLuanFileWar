package com.solienlac.khoaluan.web.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solienlac.khoaluan.web.common.dto.LopDto;
import com.solienlac.khoaluan.web.domain.Lop;
import com.solienlac.khoaluan.web.domain.QLop;
import com.solienlac.khoaluan.web.domain.QSinhVien;
import com.solienlac.khoaluan.web.repository.LopQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class LopQueryRepositoryImpl implements LopQueryRepository {
    private final EntityManager em;
    private final QLop lop = QLop.lop;
    private final QSinhVien sinhVien =QSinhVien.sinhVien;

    @Override
    public Page<Lop> getLop(Pageable pageable, Integer idGiangVien) {
        JPAQuery query = new JPAQueryFactory(em)
                .selectFrom(lop).where(lop.giangVien.id.eq(idGiangVien))
                .offset((pageable.getPageNumber()-1)*pageable.getPageSize()).limit(pageable.getPageSize());

        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);

    }
}
