package com.solienlac.khoaluan.web.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solienlac.khoaluan.web.domain.QLop;
import com.solienlac.khoaluan.web.domain.QSinhVien;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.repository.SinhVienCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Log4j2
public class SinhVienCustomRepositoryImpl implements SinhVienCustomRepository {
    private final QSinhVien sinhVien =QSinhVien.sinhVien;
    private final QLop lop = QLop.lop;
    private final EntityManager em;


    @Override
    public Page<SinhVien> listSinhVienLopHoc(Pageable pageable, Integer idLopHoc) {
        JPAQuery query = new JPAQueryFactory(em)
                .selectFrom(sinhVien)
                .where(sinhVien.lop.id.eq(idLopHoc))
                .offset(pageable.getPageNumber()*pageable.getPageSize()).limit(pageable.getPageSize());


        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);
    }
}
