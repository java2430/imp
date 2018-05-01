package com.vaesoft.imp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.vaesoft.imp.context.data.jpa.support.BaseEntityListener;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class, BaseEntityListener.class })
public class BaseEntity {
	@Id
	@Column(name = "c_id", nullable = false, unique = true, length = 50)
	@GeneratedValue(generator = "myIdStrategy")
	@GenericGenerator(name = "myIdStrategy", strategy = "uuid")
	private String id;

	@Column(name = "dt_create_time")
	private Date createTime;

	@Column(name = "dt_update_time")
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
