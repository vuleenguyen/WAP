package com.mum.edu.common;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;

public class MoneyTag extends SimpleTagSupport {

	private String color, text, fontSize;
	private Integer fontWeight;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public Integer getFontWeight() {
		return fontWeight;
	}

	public void setFontWeight(Integer fontWeight) {
		this.fontWeight = fontWeight;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (!StringUtils.isBlank(color) && !StringUtils.isBlank(text) && !StringUtils.isBlank(fontSize)
				&& !Objects.isNull(fontWeight)) {
			out.write(String.format("<span style='color: %s; font-size: %s; font-weight: %s'>%s</span>", 
					color,fontSize, fontWeight, text));
		} else if (StringUtils.isBlank(color)) {
			out.write(String.format("<span style='font-size: %s; font-weight: %s'>%s</span>", 
					fontSize, fontWeight, text));
		} 
	}
}
