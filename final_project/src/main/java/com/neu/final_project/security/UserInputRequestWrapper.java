package com.neu.final_project.security;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.web.util.HtmlUtils;

public class UserInputRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, String[]> parameterMap;

	public UserInputRequestWrapper(HttpServletRequest request) {
		super(request);
		parameterMap = request.getParameterMap();
	}

	@Override
	public String[] getParameterValues(String key) {
		String[] values = parameterMap.get(key);
		if (values == null)
			return null;
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = escapeXSS(values[i]);
		}
		return encodedValues;
	}

	private String escapeXSS(String value) {
		value = HtmlUtils.htmlEscape(value);
		Pattern tmpPattern = Pattern.compile("[sS][cC][rR][iI][pP][tT]");
		Matcher tmpMatcher = tmpPattern.matcher(value);
		if (tmpMatcher.find())
			value = tmpMatcher.replaceAll(tmpMatcher.group(0) + "\\\\");
		return value;
	}

}
