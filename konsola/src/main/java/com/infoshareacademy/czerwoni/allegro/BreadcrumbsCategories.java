package com.infoshareacademy.czerwoni.allegro;

import com.infoshareacademy.czerwoni.parse.ParseXmlAllegroCategories;

import java.util.List;

public class BreadcrumbsCategories {

    public static void breadcrumbsPrinter(int idAtm){



        List<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
        StringBuilder sB = new StringBuilder();
        int idHelper = idAtm;

        for (AllegroCategory alC : allegroCategories) {
            if (alC.getCatId().equals(idAtm)) {
                sB.append(alC.getCatName());
                idHelper = alC.getCatParent();
            }
            if (alC.getCatId().equals(0)) {
                System.out.println("Nie ma rodziców :( "); //test
                break;
            }
        }
        if (idHelper != 0)breadcrumbsPrinter(idHelper);
        System.out.print(sB.append("<--"));
    }

}




