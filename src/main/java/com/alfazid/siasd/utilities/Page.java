package com.alfazid.siasd.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www.alfaz.id mail : mohirwanh@gmail.com on 01/09/19.
 */
public class Page<E> {

    private int pageNumber;
    private int pagesAvailable;
    private List<E> pageItems = new ArrayList<E>();

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }

    public void setPageItems(List<E> pageItems) {
        this.pageItems = pageItems;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPagesAvailable() {
        return pagesAvailable;
    }

    public List<E> getPageItems() {
        return pageItems;
    }
}