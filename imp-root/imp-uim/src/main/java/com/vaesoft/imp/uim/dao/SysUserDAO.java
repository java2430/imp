package com.vaesoft.imp.uim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaesoft.imp.uim.entity.SysUser;

@Repository
public interface SysUserDAO extends JpaRepository<SysUser, String> {

}
