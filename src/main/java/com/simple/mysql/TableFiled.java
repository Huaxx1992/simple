package com.simple.mysql;

public class TableFiled {

	/**
	 * 字段名
	 */
	private String filed;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 未定义
	 */
	private String collation;

	/**
	 * 非空约束<br>
	 * Y:可以为空；N：不可为空<br>
	 * PS:强烈不建议字段设置可以为空，设置默认值比较合适<br>
	 */
	private Boolean nullx;

	/**
	 * 键类型<br>
	 * NONE: 普通<br>
	 * PK: 主键<br>
	 * FK: 外键<br>
	 */
	private String key;

	/**
	 * 默认值
	 */
	private String defaultx;

	/**
	 * 未定义
	 */
	private String extra;

	/**
	 * 未定义
	 */
	private String privileges;

	/**
	 * 字段注释
	 */
	private String conmment;

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCollation() {
		return collation;
	}

	public void setCollation(String collation) {
		this.collation = collation;
	}

	public Boolean getNullx() {
		return nullx;
	}

	public void setNullx(Boolean nullx) {
		this.nullx = nullx;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDefaultx() {
		return defaultx;
	}

	public void setDefaultx(String defaultx) {
		this.defaultx = defaultx;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public String getConmment() {
		return conmment;
	}

	public void setConmment(String conmment) {
		this.conmment = conmment;
	}

}
