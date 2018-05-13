package com.vaesoft.imp.uim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vaesoft.imp.uim.entity.SysUser;

@Repository
public interface SysUserDAO extends JpaRepository<SysUser, String> {

	SysUser findByUsername(String username);
	
	@Modifying
	@Query(value="update SysUser set email = :email where username = :username")
	void update(@Param("email") String email,@Param("username") String username);
}
