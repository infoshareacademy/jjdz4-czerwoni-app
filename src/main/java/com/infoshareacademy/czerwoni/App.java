package com.infoshareacademy.czerwoni;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        QuestionReader questionReader = new QuestionReader();
        ArrayList<Question> questionArrayList = new ArrayList<>();
        questionArrayList=questionReader.getQuestionList();
        for (int i=0;i<questionArrayList.size();i++) {
            System.out.println(questionArrayList.get(i).getQuestionName());
            for (int k = 0; k < questionArrayList.get(i).getAnswerList().size(); k++) {
                System.out.println(questionArrayList.get(i).getAnswerList().get(k).getAnswerName());
            }
        }
    }
}
