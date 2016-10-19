package com.hewe.web.form;

import java.util.HashMap;
import java.util.Map;

public class SelectItem {
	private static final Map<Integer, String> SEXES;
	static {
		SEXES = new HashMap<Integer, String>();
		SEXES.put(1, "男");
		SEXES.put(2, "女");
	}

	public static Map<Integer, String> sex() {
		return SEXES;
	}
}
