package com.hewe.test.util.model;

import java.util.List;

public class Page {

	public static final int PAGESIZE = 3;// 每页数据数量
	public static final int SHOWPAGENUM = 10;// 显示的页面索引数量

	private int totalPage;// 总页数
	private int totalRecord;// 总记录数
	private int currentPageNum;// 当前页数
	private int startIndex;// 开始索引
	private List list;// 存放数据

	private int startPage;
	private int endPage;

	public Page(int currentPageNum, int totalRecord) {
		this.currentPageNum = currentPageNum;
		this.totalRecord = totalRecord;

		// 计算总页数
		this.totalPage = (this.totalRecord + PAGESIZE - 1) / PAGESIZE;
		// 计算从数据库哪里开始取
		this.startIndex = (this.currentPageNum - 1) * PAGESIZE;

		if (this.totalPage <= SHOWPAGENUM) {
			this.startPage = 1;
			this.endPage = this.totalPage;
		} else {
			this.startPage = this.currentPageNum - 4;
			this.endPage = this.currentPageNum + 5;

			if (this.startPage < 1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.totalPage) {
				this.endPage = this.totalPage;
				this.startPage = this.totalPage - 9;
			}
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public List getList() {
		return list;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
