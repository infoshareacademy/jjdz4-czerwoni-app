package com.infoshareacademy.czerwoni;
package pl.isa.parserXML;

        import java.util.ArrayList;
        import java.util.List;

public class AllegroItem {

    private int id;
    private String name;
    private int parent;
    private int position;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}


class AllegroCategoryModel {
    public AllegroCategoryModel(int id, String name, List<AllegroCategoryModel> childCategories) {
        this.id = id;
        Name = name;
        this.childCategories = childCategories;

        for (AllegroCategoryModel child : this.childCategories) {
            child.setParentCategory(this);
        }
    }

    public int id;
    public String Name;
    public List<AllegroCategoryModel> childCategories;
    public AllegroCategoryModel parentCategory;

    public void setParentCategory(AllegroCategoryModel parentCategory) {
        this.parentCategory = parentCategory;
    }

    public AllegroCategoryModel getParentCategory() {
        return parentCategory;
    }

}

class AllegroExample {
    public AllegroExample {
        List<AllegroCategoryModel> level3 = new ArrayList<AllegroCategoryModel>();

        List<AllegroCategoryModel> level2 = new ArrayList<AllegroCategoryModel>();
        level2.add(new AllegroCategoryModel(2, "level 2 item", level3));

        AllegroCategoryModel level1 = new AllegroCategoryModel(1, "root", level2);

        for(AllegroCategoryModel category : level1.childCategories) {
            if (!category.childCategories.isEmpty()) {

            }

            for (AllegroCategoryModel categoryModel : category.childCategories){

            }
        }
    }

}