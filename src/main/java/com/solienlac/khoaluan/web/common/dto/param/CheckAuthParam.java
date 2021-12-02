package com.solienlac.khoaluan.web.common.dto.param;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CheckAuthParam {
    private String token;
    private Integer id;
}
