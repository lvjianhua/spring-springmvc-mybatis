package com.hfxt.tool;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	//鐟滅増鎸告晶鐘炽亜閻㈢數鍨�
    private int currentPage;

    //婵絽绻橀妴澶愬及閸撗佷粵闁告垹濮靛锟�   
    private int pageSize;

    //闁轰胶澧楀畵浣规償閹捐揪鎷烽柛蹇撳船椤у浜搁幋鐐磋拫
    private int total;

    //闁诡剝顕ч崣锟犲礆閸℃洝绀嬪鑸佃壘閻垱銇勯敓锟�   
    private int pageCount;

    public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


    // The records of page designed
    private List<T> pageRecords;

    public int getCurrentPage() {
        return currentPage;
    }
    
    public Pager() {
    	this(1, 0, 2, new ArrayList());
    }
    
    
    public int getPageCount() {
        // If there is no data in database.
        if (total == 0) {
            pageCount = 1;
            return pageCount;
        }
        boolean isZero = total % pageSize == 0;
        pageCount = total / pageSize;
        pageCount = isZero? pageCount : pageCount + 1;
        return pageCount;
    }

    
	public Pager(int currentPage,int pageSize) {
		this(currentPage, 0, pageSize, new ArrayList());
	}
	
	public Pager(int currentPage, int totalSize, int pageSize, List data) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.total = totalSize;
		this.pageRecords = data;
	}

    /**
     * make sure the page is in the range of the total pages
     * 
     * @param currentPage
     *            current page
     */
    public void setCurrentPage(int currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
            return;
        }
        /*if (currentPage > getPageCount()) {
            this.currentPage = getPageCount();
            return;
        }*/
        this.currentPage = currentPage;
    }

    /**
     * get page size
     * 
     * @return page size number
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * set page size
     * 
     * @param pageSize
     *            page size number
     */
    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * get total records
     * 
     * @return total record's number
     */
    public int getTotal() {
        return total;
    }

    /**
     * set total records
     * 
     * @param totalRecords
     *            total record number
     */
    public void setTotal(int totalRecords) {
        this.total = totalRecords;
    }

    /**
     * Get the total count of the page
     * 
     * @return count number
     */
 


    
    public List<T> getPageRecords() {
        return pageRecords;
    }

	public void setPageRecords(List<T> pageRecords) {
		this.pageRecords = pageRecords;
	}
}
