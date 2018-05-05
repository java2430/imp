package com.vaesoft.imp.uim.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaesoft.imp.uim.entity.SysUser;
import com.vaesoft.imp.uim.service.SysUserService;
import com.vaesoft.imp.web.exception.EntityNotFoundException;

@RestController
public class SysUserController {

	@Resource
	private SysUserService sysUserService;

	@RequestMapping("user/add/{username}")
	public ResponseEntity<SysUser> add(@PathVariable(name = "username", required = true) String username) {
		SysUser user = new SysUser();
		user.setUsername(username);
		user = sysUserService.save(user);
		return ResponseEntity.ok().body(user);
	}

	@RequestMapping("user/page/{page}/{size}")
	public ResponseEntity<Page<SysUser>> page(@PathVariable(name = "page") int page,
			@PathVariable(name = "size") int size) {
		Page<SysUser> pageObj = sysUserService.findPage(page, size);
		return ResponseEntity.ok().body(pageObj);
	}

	@RequestMapping("user/get/{username}")
	public ResponseEntity<SysUser> get(@PathVariable(name = "username") String username) throws Exception {
		SysUser user = sysUserService.findByUserName(username);
		if (user == null) {
			throw new EntityNotFoundException("not found : username = " + username);
		}
		return ResponseEntity.ok().body(user);
	}
}
