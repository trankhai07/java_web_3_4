package com.laptrinhweb.model;

import java.util.List;

public class Abstract<T> {
	private List<T> list_item;
	private Integer page;
	private Integer maxpage;
	private Integer totalpage;
	private Integer totalitem;
	private String sortName;
	private String sortBy;
	private String type;
	private Integer[]ids;

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}


	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}


	public Integer getTotalitem() {
		return totalitem;
	}

	public void setTotalitem(Integer totalitem) {
		this.totalitem = totalitem;
	}


	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(Integer maxpage) {
		this.maxpage = maxpage;
	}

	public Integer getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}

	public List<T> getList_item() {
		return list_item;
	}

	public void setList_item(List<T> list_item) {
		this.list_item = list_item;
	}
}
