package com.hewe.test.model;

import javax.persistence.Embeddable;

/**
 * Ƕ����
 * @author HEWE
 *2016��10��14��
 */
@Embeddable
public class Name {
	private String first;
	private String last;

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
}
