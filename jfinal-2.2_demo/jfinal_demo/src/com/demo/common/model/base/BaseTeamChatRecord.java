package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTeamChatRecord<M extends BaseTeamChatRecord<M>> extends Model<M> implements IBean {

	public void setGroupId(java.lang.String groupId) {
		set("group_id", groupId);
	}

	public java.lang.String getGroupId() {
		return get("group_id");
	}

	public void setTime(java.lang.String time) {
		set("time", time);
	}

	public java.lang.String getTime() {
		return get("time");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

}
