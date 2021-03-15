package PojoClasses;

import java.util.List;

public class CricketHomeAllCategory {
 private  String categoryTitle;
 private List<CricketHomeMatchCategory> categoryItemList;

    public CricketHomeAllCategory(String categoryTitle, List<CricketHomeMatchCategory> categoryItemList) {
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<CricketHomeMatchCategory> getCategoryItem() {
        return categoryItemList;
    }

    public void setCategoryItem(List<CricketHomeMatchCategory> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }
}
