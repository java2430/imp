package com.vaesoft.imp.context.data.jpa.support;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import com.vaesoft.imp.entity.BaseEntity;

@Component
public class BaseEntityListener {
	/**
	 * Before add entity, init createDate and updateDate
	 * 
	 * @param baseEntity
	 */
	@PrePersist
	public void initEntity(BaseEntity baseEntity) {
		Date now = new Date();
		baseEntity.setCreateTime(now);
		baseEntity.setUpdateTime(now);
	}

	/**
	 * Before update entity ,set updateDate
	 */
	@PreUpdate
	public void updateEntity(BaseEntity baseEntity) {
		baseEntity.setUpdateTime(new Date());
	}
}
