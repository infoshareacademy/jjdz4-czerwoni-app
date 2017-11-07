package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

public class BreadcrumbsCategories {

    public static void breadcrumbsPrinter(int idAtm){

    /**
     Klasa do wypisywania parentów np. nokia wypisze:
     Telefony i Akcesoria < -- Telefony komórkowe < - - Nokia
     ***/

        ArrayList<AllegroCategory> allegroCategories = ParseXmlAllegroCategories.deserialization();
        StringBuilder sB = new StringBuilder();
        int idHelper = idAtm;
        //System.out.println("wchodzi do petli alC"+ idAtm);

        for (AllegroCategory alC : allegroCategories) {
            if (alC.getCatId().equals(idAtm)) {
                sB.append(alC.getCatName());
              //  System.out.println("pierwszy if append");
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




