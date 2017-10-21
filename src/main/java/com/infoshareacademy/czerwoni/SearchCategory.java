package com.infoshareacademy.czerwoni;

import jdk.nashorn.internal.ir.WhileNode;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SearchCategory {
    QuestionReader questionReader = new QuestionReader();
    List<Question> questions = questionReader.getQuestionList();
    Category category = new Category();
    List<Category> categoryList = category.getCategoryList();
    int k = 0;

    public void showQuestion(String id) {

        Scanner answerScanner = new Scanner(System.in);
            for (Question q : questions) {
                if (id.equals(String.valueOf(q.getQuestionId()))) {
                    System.out.println(q.getQuestionName());
                    q.getAnswerList().forEach(s -> System.out.println(s.getAnswerName()));
                    String userAnswer = answerScanner.nextLine();
                    q.getAnswerList().forEach(s -> {
                        if (userAnswer.equals(s.getAnswerName().substring(0, 1))) {
                            showQuestion(String.valueOf(s.getRelatedQuest()));
                            return;
                        }
                    });
                }
            }
}




    public static void main(String args[]) {

        SearchCategory searchCategory = new SearchCategory();
        String id = "1";

        searchCategory.showQuestion(id);

    }
}
