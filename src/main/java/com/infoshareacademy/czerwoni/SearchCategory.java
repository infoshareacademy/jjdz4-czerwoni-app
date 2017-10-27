package com.infoshareacademy.czerwoni;

import java.util.List;
import java.util.Scanner;

class SearchCategory {
    private QuestionReader questionReader = new QuestionReader();
    private List<Question> questions = questionReader.getQuestionList();
    private String answerId;
    private Category category = new Category();
    private List<Category> categoryList = category.getCategoryList();


    String getAnswerId() {
        return answerId;
    }

// Wyświetlanie pytąń i odpowiedzi

    void showQuestion(String id) {
        boolean checkAnswer = true;
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
                                    String isOK = answerScanner.nextLine();
                                    System.out.println("");
                                    if (isOK.toLowerCase().equals("t")) {
                                        showQuestion(String.valueOf(a.getRelatedQuest()));
                                    } else {
                                        System.out.println("\033[33mLink do Allegro\033[0m\n");
                                        System.out.println("Naciśnij dowolny klawisz aby przejść do Menu\n");
                                        answerScanner.nextLine();
                                        break;
                                    }
                                } else {
                                    System.out.println("\033[33mLink do Allegro\033[0m\n");
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

    // Wyświetlenie wyniku - kategorii - po odpowiedzi na pytania

    String getCategoryName(String idCat) {
        String categoryName = null;
        for (Category cat : categoryList) {
            if (idCat.equals(String.valueOf(cat.getCategoryId()))) {
                categoryName = cat.getCategoryName();
            }
        }
        return categoryName;
    }
}
