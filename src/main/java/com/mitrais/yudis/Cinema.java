package com.mitrais.yudis;

public class Cinema {
	private int page;
	private int total;
	private int total_page;
	private Data[] data;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	
	public Data[] getData() {
		return data;
	}
	public void setData(Data[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Cinema [page=" + page + ", total=" + total + ", total_page=" + total_page + ", data=" + data + "]";
	}
	
	
}
