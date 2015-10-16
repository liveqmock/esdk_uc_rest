package com.huawei.esdk.uc.north.rest.bean.ctc;

import java.util.List;

public class ConfInfoBean {
	/*
	 * 会议主题
	 */
	private String subject;
	
	/*
	 * 是否录音
	 */
	private String record;
	
	/*
	 * 主持人号码
	 */
	private String emCee;
	
	/*
	 * 创建者
	 */
	private String creator;
	
	/*
	 * 人数
	 */
	private int num;
	
	private List<ConfUserBean> users;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getEmCee() {
		return emCee;
	}

	public void setEmCee(String emCee) {
		this.emCee = emCee;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<ConfUserBean> getUsers() {
		return users;
	}

	public void setUsers(List<ConfUserBean> users) {
		this.users = users;
	}
}
