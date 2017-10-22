package com.infoshareacademy.czerwoni;

import java.util.List;
import java.util.Scanner;

class SearchCategory {
    private QuestionReader questionReader = new QuestionReader();
    private List<Question> questions = questionReader.getQuestionList();
    private String answerId;


    public String getAnswerId() {
        return answerId;
    }


    void showQuestion(String id) {
        boolean checkAnswer = true;
        Scanner answerScanner = new Scanner(System.in);
        for (Question q : questions) {
            if (id.equals(String.valueOf(q.getQuestionId()))) {
                System.out.println(q.getQuestionName());
                q.getAnswerList().forEach(s -> System.out.println(s.getAnswerName()));
                System.out.print("Podaj odpowiedź [a,b,c]: ");
                while (checkAnswer) {
                    String userAnswer = answerScanner.nextLine();
                    if (userAnswer.toLowerCase().equals("a") || userAnswer.toLowerCase().equals("b") || userAnswer.toLowerCase().equals("c")){
                        System.out.println("");
                        for (Answer s : q.getAnswerList()) {
                            if (userAnswer.toLowerCase().equals(s.getAnswerName().substring(0, 1))) {
                                this.answerId = String.valueOf(s.getAnswerId());
                                showQuestion(String.valueOf(s.getRelatedQuest()));
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

    void showCategory() {
        Category category = new Category();
        List<Category> categoryList = category.getCategoryList();
        SearchCategory searchCategory = new SearchCategory();
        String id = "1";
        String catId;
        searchCategory.showQuestion(id);
        catId = searchCategory.getAnswerId();
        for (Category cat : categoryList) {
            if (catId.equals(String.valueOf(cat.getCategoryId())))
                System.out.println("Twoja kategoria Allegro to: " + cat.getCategoryName());
        }
    }
}
