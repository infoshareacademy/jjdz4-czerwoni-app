package com.infoshareacademy.czerwoni;

import java.util.List;
import java.util.Scanner;

/**
 * Klasa udostępnia metody pozwalające na wyświetlanie pytań i szukoanie właściwych kategorii Allegro
 */
class SearchCategory {
    private QuestionReader questionReader = new QuestionReader();
    private List<Question> questions = questionReader.getQuestionList();
    private String answerId;
    private Category category = new Category();
    private List<Category> categoryList = category.getCategoryList();

    /**
     * Metoda wyświetla pytąnia i odpowiedzi oraz przyjmuje odpowiedzi od użytkownika
     * wywołuje metody getCategoryName(w celeu wyświetlenia odpowiedniej kategorii Allegro) oraz
     * wywołuję metodę getAllegroLink(w celu wyświetlenia odpowiedniego linku Allegro
      */

    void showQuestion(String id) {
        boolean checkAnswer = true;
        boolean isFinish = true;
        String isOK = null;
        Scanner answerScanner = new Scanner(System.in);
        for (Question q : questions) {
            if (id.equals(String.valueOf(q.getQuestionId()))) {
                System.out.println(q.getQuestionName());
                q.getAnswerList().forEach(s -> System.out.println(s.getAnswerName()));
                System.out.print("Podaj odpowiedź [a,b,c]: ");
                //sprawdzanie odpowiedzi
                while (checkAnswer) {
                    String userAnswer = answerScanner.nextLine();
                    if (userAnswer.toLowerCase().equals("a") || userAnswer.toLowerCase().equals("b") || userAnswer.toLowerCase().equals("c")) {
                        System.out.println("");
                        for (Answer a : q.getAnswerList()) {
                            if (userAnswer.toLowerCase().equals(a.getAnswerName().substring(0, 1))) {
                                this.answerId = String.valueOf(a.getAnswerId());
                                System.out.println("Twoja kategoria Allegro to: \033[33m" + getCategoryName(answerId) + "\033[0m\n");
                                if (a.getRelatedQuest() != 0) {
                                    System.out.print("Czy chcesz szukać dalej?(podaj T lu N): ");
                                    while (isFinish) {
                                        isOK = answerScanner.nextLine();
                                        System.out.println("");
                                        if (!(isOK.toLowerCase().equals("n")) && !(isOK.toLowerCase().equals("t"))) {
                                            System.out.print("Wprowadziłeś niepoprawny znak, spróbuj jeszcze raz:  ");
                                        } else {
                                            isFinish = false;
                                        }
                                    }
                                    if (isOK.toLowerCase().equals("t")) {
                                        showQuestion(String.valueOf(a.getRelatedQuest()));
                                    } else {
                                        System.out.println("\033[33mLink do Allegro: " + getAllegroLink(answerId) + "\033[0m\n");
                                        System.out.println("Naciśnij dowolny klawisz aby przejść do Menu\n");
                                        answerScanner.nextLine();
                                        break;
                                    }
                                } else {
                                    System.out.println("\033[33mLink do Allegro: " + getAllegroLink(answerId) + "\033[0m\n");
                                    System.out.println("Naciśnij dowolny klawisz aby przejść do Menu\n");
                                    answerScanner.nextLine();
                                }
                            }
                        }
                        break;
                    } else {
                        System.out.print("Podałeś niepoprawną odpoowiedź, jescze raz: ");
                    }
                }
            }
        }

    }

    /**
     * Metoda zwraca nazwę kategorii o zadanym id kategorii
     * @param idCat id kategorii
     * @return nazwa kategorii (w XML<cat-item-name>)
     */

    String getCategoryName(String idCat) {
        String categoryName = null;
        for (Category cat : categoryList) {
            if (idCat.equals(String.valueOf(cat.getCategoryId()))) {
                categoryName = cat.getCategoryName();
            }
        }
        return categoryName;
    }

    /**
     * Metoda zwraca link Allegro o zadanym id kategorii
     * @param idCat id kategorii
     * @return link Allegro (w XML <cat-item-link>)
     */
    String getAllegroLink(String idCat) {
        String allegroLink = null;
        for (Category cat : categoryList) {
            if (idCat.equals(String.valueOf(cat.getCategoryId()))) {
                allegroLink = cat.getCategoryAllegroLink();
            }
        }
        return allegroLink;
    }
}
