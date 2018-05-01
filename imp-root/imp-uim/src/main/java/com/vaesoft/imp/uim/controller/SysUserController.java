package com.vaesoft.imp.uim.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaesoft.imp.uim.entity.SysUser;
import com.vaesoft.imp.uim.service.SysUserService;
import com.vaesoft.imp.web.model.ActionResult;

@RestController
public class SysUserController {

	@Resource
	private SysUserService sysUserService;

	@RequestMapping("user/add/{username}")
	public ActionResult add(@PathVariable(name = "username", required = true) String username) {
		SysUser user = new SysUser();
		user.setUsername(username);
		user = sysUserService.save(user);
		return ActionResult.newSuccessActionResult("", user);
	}

	@RequestMapping("user/page/{page}/{size}")
	public ActionResult page(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
		Page<SysUser> pageObj = sysUserService.findPage(page, size);
		return ActionResult.newSuccessActionResult("", pageObj);
	}
}
