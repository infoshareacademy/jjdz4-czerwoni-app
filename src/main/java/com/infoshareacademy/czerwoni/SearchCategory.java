package com.infoshareacademy.czerwoni;

import java.util.List;
import java.util.Scanner;

public class SearchCategory {
    QuestionReader questionReader = new QuestionReader();
    List<Question> questions = questionReader.getQuestionList();
    private String answerId;

    public String getAnswerId() {
        return answerId;
    }


    public void showQuestion(String id) {

            Scanner answerScanner = new Scanner(System.in);
            //String answerId=null;
            for (Question q : questions) {
                if (id.equals(String.valueOf(q.getQuestionId()))) {
                    System.out.println(q.getQuestionName());
                    q.getAnswerList().forEach(s -> System.out.println(s.getAnswerName()));
                    String userAnswer = answerScanner.nextLine();
                    for(Answer s : q.getAnswerList()){
                        if (userAnswer.equals(s.getAnswerName().substring(0, 1))) {
                            this.answerId=String.valueOf(s.getAnswerId());
                            showQuestion(String.valueOf(s.getRelatedQuest()));
                        }
                    }
                }
            }

    }

    public void showCategory() {
        Category category = new Category();
        List<Category> categoryList = category.getCategoryList();
        SearchCategory searchCategory = new SearchCategory();
        String id = "1";
        String catId;
        searchCategory.showQuestion(id);
        catId = searchCategory.getAnswerId();
        for (Category cat : categoryList) {
            if(catId.equals(String.valueOf(cat.getCategoryId())))
            System.out.println("Twoja kategoria Allegro to: "+cat.getCategoryName());
        }
    }
}
