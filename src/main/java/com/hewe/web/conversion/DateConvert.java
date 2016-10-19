package com.hewe.web.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date> {
	private static final Logger log = Logger.getLogger(DateConvert.class);

	private String pattern = null;

	public Date convert(String source) {

		if (source == null || source.trim().equals("")) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		format.setLenient(false);
		try {
			return format.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}

	}

	public String getPattern() {
		if (this.pattern == null) {
			this.pattern = "yyyy-MM-dd";
		}
		return pattern;
	}

	public void setPattern(String pattern) {

		this.pattern = pattern;
		log.debug("pattern:" + this.pattern);
	}

}
