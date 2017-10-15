package com.infoshareacademy.czerwoni;

import java.util.ArrayList;
import java.util.List;

class AllegroExample {
    public AllegroExample() {
        List<AllegroCategoryModel> level3 = new ArrayList<AllegroCategoryModel>();

        List<AllegroCategoryModel> level2 = new ArrayList<AllegroCategoryModel>();
        level2.add(new AllegroCategoryModel(2, "level 2 item", true, level3));

        AllegroCategoryModel level1 = new AllegroCategoryModel(1, "root", true, level2);

        for (AllegroCategoryModel category : level1.catItemsChild) {
            if (!category.catItemsChild.isEmpty()) {



            }

//                for (AllegroCategoryModel categoryModel : category.catItemsChild) {
//
//                }
        }
    }

}