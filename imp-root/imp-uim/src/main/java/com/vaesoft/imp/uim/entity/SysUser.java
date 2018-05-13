package com.vaesoft.imp.uim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.vaesoft.imp.entity.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "t_sys_user")
@ApiModel(value="ParamBean1", description="ParamBean1 desc") 
public class SysUser extends BaseEntity {

	@Column(name = "c_username", length = 50, unique = true, nullable = false)
	private String username;

	@ApiModelProperty(value="email编号",name="email") 
	@Column(name = "c_email", length = 50)
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SysUser [username=" + username + ", email=" + email + "]";
	}

}
