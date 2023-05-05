package com.laptrinhweb.paging;

import com.laptrinhweb.sorter.Sorter;

public interface Pageble {
    public Integer getPage();
    public Integer getOffset();
    public Integer getLimit();
    public Sorter getSorter();
}
