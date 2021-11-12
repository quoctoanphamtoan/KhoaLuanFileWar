package com.solienlac.khoaluan.web.domain.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

//
//
    @CreatedDate
    @Column(name = "ngayTao")
    private Date ngayTao;
//

    @Setter
    @LastModifiedDate
    @Column(name = "ngaySua")
    private Date ngaySua;

}