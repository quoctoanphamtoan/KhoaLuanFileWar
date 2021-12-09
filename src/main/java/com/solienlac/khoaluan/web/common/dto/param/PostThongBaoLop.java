package com.solienlac.khoaluan.web.common.dto.param;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PostThongBaoLop {
    private String tieuDe;
    private String noiDung;
}
