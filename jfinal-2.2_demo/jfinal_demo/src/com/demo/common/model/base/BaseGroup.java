package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGroup<M extends BaseGroup<M>> extends Model<M> implements IBean {

	public void setGroupId(java.lang.String groupId) {
		set("group_id", groupId);
	}

	public java.lang.String getGroupId() {
		return get("group_id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setCaptain(java.lang.String captain) {
		set("captain", captain);
	}

	public java.lang.String getCaptain() {
		return get("captain");
	}

	public void setMembers(java.lang.String members) {
		set("members", members);
	}

	public java.lang.String getMembers() {
		return get("members");
	}

}