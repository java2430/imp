package com.vaesoft.imp.uim.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vaesoft.imp.uim.dao.SysUserDAO;
import com.vaesoft.imp.uim.entity.SysUser;
import com.vaesoft.imp.uim.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserDAO sysUserDao;

	@Override
	public SysUser save(SysUser sysUser) {
		return sysUserDao.save(sysUser);
	}

	@Override
	public List<SysUser> findAll() {
		return sysUserDao.findAll();
	}

	@Override
	public Page<SysUser> findPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return sysUserDao.findAll(pageable);
	}

	@Override
	public SysUser findByUserName(String username) {
		return sysUserDao.findByUsername(username);
	}

	@Override
	@Transactional
	public void updateEmailByUsername(String email, String username) {
		sysUserDao.update(email, username);
	}

}
