package com.infoshareacademy.czerwoni.phraseFinder.dao;

import com.infoshareacademy.czerwoni.allegro.AllegroCategory;

import javax.ejb.Local;
import java.util.List;


@Local
public interface PhraseService {

    List<AllegroCategory> getFirst5Categories(String phrase);
    String getName(List<AllegroCategory> listOfFive, int i);
    String getLink(List<AllegroCategory> listOfFive, int i);
}
