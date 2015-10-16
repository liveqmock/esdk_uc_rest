package com.huawei.esdk.uc.north.rest.bean.ctc;

public class ConfUserBean {
	/*
	 * 与会者号码
	 */
	private String cee;

	/*
	 * 与会者状态
	 */
	private String state;

	/*
	 * 与会者姓名
	 */
	private String displayName;

	/*
	 * 与会者帐号
	 */
	private String espaceAccount;

	/*
	 * 角色
	 */
	private String role;

	/*
	 * 媒体类型，如支持音频，支持音视频
	 */
	private String mediaType;

	/*
	 * 与会者类型，如UC用户，智真用户
	 */
	private String userType;

	public String getCee() {
		return cee;
	}

	public void setCee(String cee) {
		this.cee = cee;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEspaceAccount() {
		return espaceAccount;
	}

	public void setEspaceAccount(String espaceAccount) {
		this.espaceAccount = espaceAccount;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
