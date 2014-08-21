package org.dsns.common.beans.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T extends Serializable> {
	protected int DEFAULT_PAGE_SIZE = 12, DEFAULT_CUR_PAGE_NO = 1;
	
	private int pageSize = DEFAULT_PAGE_SIZE;
	private int curPageNo = DEFAULT_CUR_PAGE_NO;
	private long totalRowCount;
	private long totalPageNo;
	private List<T> curPageRows = new ArrayList<T>();

	public Page(int curPageNo, int pageSize, long totalRowCount) {
		this(curPageNo, pageSize, totalRowCount, null);
	}
	
	public Page(int curPageNo, int pageSize, long totalRowCount, List<T> curPageRows) {
		this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
		this.totalRowCount = totalRowCount < 0 ? 0 : totalRowCount;
		this.totalPageNo = this.totalRowCount % (long)this.pageSize == 0 ? this.totalRowCount / (long)this.pageSize : this.totalRowCount / (long)this.pageSize + 1;
		this.totalPageNo = (this.totalPageNo <= 0) ? 1L : this.totalPageNo;
		this.curPageNo = curPageNo <= 0 ? DEFAULT_CUR_PAGE_NO : (curPageNo >= (int)this.totalPageNo ? (int)this.totalPageNo : curPageNo);
		this.curPageRows = curPageRows;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurPageNo() {
		return curPageNo;
	}

	public void setCurPageNo(int curPageNo) {
		this.curPageNo = curPageNo;
	}

	public long getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(long totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public long getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo(long totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public List<T> getCurPageRows() {
		return curPageRows;
	}

	public void setCurPageRows(List<T> curPageRows) {
		this.curPageRows = curPageRows;
	}
	
	public int getFirstPage() {
		return 1;
	}
	
	public long getLastPage() {
		return this.totalPageNo;
	}

	public boolean isFirstPageNo() {
		return this.curPageNo <= 1;
	}
	
	public boolean isLastPageNo() {
		return (long)this.curPageNo >= this.totalPageNo;
	}
	
	public int getFirstResult() {
		return (this.curPageNo - 1) * this.pageSize;
	}
	
	public long getPrePage() {
		return this.isFirstPageNo() ? (long)this.getFirstPage() : (long)(this.curPageNo - 1);
	}
	
	public long getNextPage() {
		return this.isLastPageNo() ? this.getLastPage() : (long)(this.curPageNo + 1);
	}
}
