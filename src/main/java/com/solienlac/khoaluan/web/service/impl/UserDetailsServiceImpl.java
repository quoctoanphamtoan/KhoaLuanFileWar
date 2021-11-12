package com.solienlac.khoaluan.web.service.impl;


import com.solienlac.khoaluan.web.common.UserDetailsDto;
import com.solienlac.khoaluan.web.domain.TaiKhoan;
import com.solienlac.khoaluan.web.domain.common.Role;
import com.solienlac.khoaluan.web.repository.TaiKhoanRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private TaiKhoanRepository taiKhoanRepository;
		
	public UserDetailsServiceImpl(TaiKhoanRepository taiKhoanRepository) {
		this.taiKhoanRepository = taiKhoanRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String tenDangNhap) throws UsernameNotFoundException {
		// Get user
		TaiKhoan taiKhoan = taiKhoanRepository.findByTenDangNhap(tenDangNhap);
		if (taiKhoan == null) throw new UsernameNotFoundException("Tên đăng nhập không tồn tại!");
		
		// Get roleName in database
		Role roleName = taiKhoan.getRole();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleName.toString()));
		
		return new UserDetailsDto(tenDangNhap, taiKhoan.getMatKhau(), authorities);
	}
	

}