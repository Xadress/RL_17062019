package ccloader.application.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Paged list of generic type.
 * @author Raffaele
 *
 * @param <T> Type of objects contained in the paged list.
 */
public class PagedList<T> {
	
	private int pageNumber = 1;
	private List<T> fullList = new ArrayList<>();
	private List<T> list = new ArrayList<>();
	private int totalItems;
	private int pageSize = 6;
	
	public PagedList() {
		super();
	}
	
	public PagedList(List<T> fullList) {
		super();
		if(fullList!=null) {
			this.fullList = fullList;
			this.totalItems = fullList.size();
		}
		this.updatePageList();
	}
	
	public void updatePageList() {
		int firstPageItem = (this.pageNumber * this.pageSize) - this.pageSize;
		int lastPageItem = this.pageNumber * this.pageSize;
		if(lastPageItem>this.fullList.size()) {
			lastPageItem = this.fullList.size();
		}
		this.list = this.fullList.subList(firstPageItem, lastPageItem);
	}
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if(this.getNumberOfPages() >= pageNumber  && pageNumber >= 1) {
			this.pageNumber = pageNumber;
			this.updatePageList();
		}
	}

	public List<T> getList() {
		return list;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize>0) {
			this.pageSize = pageSize;
		}
	}
	
	public int getNumberOfPages() {
		return (int) Math.ceil((double) this.fullList.size() / this.pageSize);
		
	}

}
