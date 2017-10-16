package com.freemall.dao.entry;

/**
 * 分页的对象
 * @author LFSenior
 *
 *下午2:27:42
 *
 */
public class PageBean {
	/**
	 * 当前页，默认显示第一页
	 */
	private int currentPage=1;
	/**
	 * 每页显示的数据量
	 */
	private int pageCount=20;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 总额页数
	 */
	private int totalPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获取总也数据
	 * @return
	 */
	public int getTotalPage() {
		/**
		 * 如果数据总数不足页面数据量，返回1页
		 */
		if(totalCount<pageCount){
			return 1;
		}else{
			/**
			 * 否则向上取整
			 */
			return (int) Math.ceil((double)totalCount/pageCount);
		}
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public PageBean() {
		super();
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageCount="
				+ pageCount + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + "]";
	}
	
	
	
}
