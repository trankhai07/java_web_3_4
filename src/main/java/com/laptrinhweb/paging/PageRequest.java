package com.laptrinhweb.paging;

import com.laptrinhweb.sorter.Sorter;

public  class PageRequest implements  Pageble{
    private Integer page;
    private Integer maxpage;
    private Sorter sorter;


    public PageRequest(Integer page, Integer maxpage,Sorter sorter) {
        this.page = page;
        this.maxpage = maxpage;
        this.sorter = sorter;
    }

    @Override
    public Integer getPage() {
        return this.page;
    }

    @Override
    public Integer getOffset() {
        if(this.page != null && this.maxpage != null){
            return (this.page-1)*this.maxpage;
        }
        return null;
    }

    @Override
    public Integer getLimit() {
        return this.maxpage;
    }

    @Override
    public Sorter getSorter() {
        if(this.sorter != null) return this.sorter;
        return null;
    }


}
