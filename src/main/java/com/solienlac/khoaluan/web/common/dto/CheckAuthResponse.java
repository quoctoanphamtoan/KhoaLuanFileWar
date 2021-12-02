package com.solienlac.khoaluan.web.common.dto;

import com.solienlac.khoaluan.web.domain.common.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckAuthResponse {
    private Role role;
    private boolean isActive;
}
