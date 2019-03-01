package com.wyf.hello.utils;

/**
 * @Description: 符号枚举
 */
public enum Symbol {
	/**
	 * 反斜杠 “/”
	 */
	Backslash("/"),
	/**
	 * 点"."
	 */
	Point("."),
	/**
	 * ","
	 */
	Comma(","),
	/**
	 * ","
	 */
	Equal("="),
	/**
	 * "="
	 */
	InDash("-"),
	/**
	 * "_"
	 */
	UnderDash("_"),
	/**
	 * ":"
	 */
	Colon(":"),
	/**
	 * 中文":"
	 */
	AColon("："),
	/**
	 * "#"
	 */
	Sharp("#"),
	/**
	 * ";"
	 */
	Semicolon(";"),
	/**
	 * "'"
	 */
	Singlequotes("'"),
	/**
	 * "*"
	 */
	Star("*");

	private String label;

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	private Symbol(String _value) {
		this.label = _value;
	}

	/**
	 * 比较
	 * 
	 * @param label
	 * @return
	 */
	public boolean compare(String label) {
		if (this.label.equals(label)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.label;
	}
}
