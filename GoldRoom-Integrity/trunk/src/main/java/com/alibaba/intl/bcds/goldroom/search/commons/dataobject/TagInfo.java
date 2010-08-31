package com.alibaba.intl.bcds.goldroom.search.commons.dataobject;

import java.util.Set;

public class TagInfo {

    private String       tagName;
    private Set<Integer> ids;
    
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getAmount() {
        if (ids != null) {
            return ids.size();
        }
        return 0;
    }

    public Set<Integer> getIds() {
        return ids;
    }

    public void setIds(Set<Integer> ids) {
        this.ids = ids;
    }

}
