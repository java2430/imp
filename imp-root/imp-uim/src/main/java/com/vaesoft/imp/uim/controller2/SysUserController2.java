package com.vaesoft.imp.uim.controller2;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaesoft.imp.uim.entity.SysUser;
import com.vaesoft.imp.uim.service.SysUserService;
import com.vaesoft.imp.web.exception.EntityNotFoundException;

import io.swagger.annotations.Api;

@RestController
@Api(tags="22222222")
public class SysUserController2 {

	@Resource
	private SysUserService sysUserService;

	@RequestMapping(value="user",method= {RequestMethod.POST})
	public ResponseEntity<SysUser> add(@PathVariable(name = "username", required = true) String username) {
		SysUser user = new SysUser();
		user.setUsername(username);
		user = sysUserService.save(user);
		return ResponseEntity.ok().body(user);
	}

	
}
