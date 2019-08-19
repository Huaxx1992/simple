package com.simple.mysql;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTable {

	/**
	 * 表名
	 */
	protected String tableName;

	/**
	 * 注释
	 */
	protected String comment;

	/**
	 * 字段集合
	 */
	protected List<TableFiled> fileds = new ArrayList<>();

	/**
	 * 获取表的创建语句
	 */
	public abstract BaseTable setTable();

	/**
	 * 创建表SQL语句
	 */
	public String builderSql() {
		StringBuilder sql = new StringBuilder();
		String primaryKey = "";
		sql.append("CREATE TABLE IF NOT EXISTS `" + tableName + "`(");
		for (TableFiled filed : fileds) {
			// 设置主见
			if (KeyType.PRIMARY_KEY.equals(filed.getKey())) {
				primaryKey += ("`" + filed.getFiled() + "`" + ",");
			}
			// 字段名
			sql.append("`" + filed.getFiled() + "` ");
			// 字段类型
			sql.append(filed.getType());
			// 是否可以为空
			if (filed.getNullx()) {
				sql.append(" NULL ");
			} else {
				sql.append(" NOT NULL ");
			}
			// 默认值（默认值交由程序处理，以减小数据库和业务时间的耦合）

			// 注释(结尾加了逗号)
			sql.append("COMMENT '" + filed.getConmment() + "',");
		}

		// 如果没有设置主键，主键默认为“id”(避免不设置主键)
		if ("".equals(primaryKey)) {
			primaryKey = "`id`";
		}
		// 去除末尾的逗号
		if (primaryKey.endsWith(",")) {
			primaryKey = primaryKey.substring(0, primaryKey.length() - 1);
		}
		// 设置主键
		sql.append("PRIMARY KEY (" + primaryKey + ")) ");
		// 设置引擎类型
		sql.append("ENGINE=InnoDB ");
		// 设置字符集
		sql.append("DEFAULT CHARACTER SET=utf8 ");
		// 设置表注释
		sql.append("COMMENT='" + comment + "' ");

		return sql.toString();
	}

	/**
	 * 添加新的字段
	 */
	protected void addFiled(TableFiled filed) {
		fileds.add(filed);
	}

}
