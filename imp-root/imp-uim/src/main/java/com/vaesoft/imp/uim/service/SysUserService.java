package com.vaesoft.imp.uim.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vaesoft.imp.uim.entity.SysUser;

public interface SysUserService {

	SysUser save(SysUser sysUser);

	List<SysUser> findAll();

	Page<SysUser> findPage(int page, int size);
	
	SysUser findByUserName(String username);
	
	void updateEmailByUsername(String email,String username);

}
