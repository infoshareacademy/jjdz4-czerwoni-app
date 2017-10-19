package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

public class TestClass
{
    public static void main( String[] args ) {
        QuestionReader questionReader = new QuestionReader();
        ArrayList<Question> questionArrayList;
        questionArrayList=questionReader.getQuestionList();

        Category category = new Category();
        ArrayList<Category> categoryArrayList;
        categoryArrayList = category.getCategoryList();

        for (int i=0;i<questionArrayList.size();i++) {
            System.out.println(questionArrayList.get(i).getQuestionName());
            for (int k = 0; k < questionArrayList.get(i).getAnswerList().size(); k++) {
                System.out.println(questionArrayList.get(i).getAnswerList().get(k).getAnswerName());
            }
        }

        for (int j=0;j<categoryArrayList.size();j++) {
            System.out.println(categoryArrayList.get(j).getCategoryName());

        }

        for (Category c : categoryArrayList) {
            if (c.isCategoryVisible()){
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
        }


    }
}
