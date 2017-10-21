package com.infoshareacademy.czerwoni;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SearchCategory {
    QuestionReader questionReader = new QuestionReader();
    List<Question> questions = questionReader.getQuestionList();
    Category category = new Category();
    List<Category> categoryList = category.getCategoryList();
    int k = 0;
    public void showQuestion(int k) {

        System.out.println(questions.get(k).getQuestionName());
        questions.get(k).getAnswerList().forEach(a -> System.out.println(a.getAnswerName()));
        Scanner answerScanner = new Scanner(System.in);
        for (Answer a : questions.get(k).getAnswerList()) {
            String userAnswer = answerScanner.nextLine();
            if (userAnswer.equals(a.getAnswerName().substring(0, 1))) {
                for (Question q : questions) {
                    if (q.getQuestionId() == a.getRelatedQuest()) {
                        System.out.println(q.getQuestionName());
                        q.getAnswerList().forEach(s -> System.out.println(s.getAnswerName()));
                    }
                }
            }
            k++;

        }
        showQuestion(k);
    }


    public static void main(String args[]) {

        SearchCategory searchCategory = new SearchCategory();
        int i = 0;

        searchCategory.showQuestion(i);

    }
}
