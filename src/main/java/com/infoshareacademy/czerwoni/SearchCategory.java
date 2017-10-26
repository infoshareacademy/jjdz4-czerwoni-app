package com.infoshareacademy.czerwoni;

import java.util.List;
import java.util.Scanner;

class SearchCategory {
    private QuestionReader questionReader = new QuestionReader();
    private List<Question> questions = questionReader.getQuestionList();
    private String answerId;


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
                while (checkAnswer) {
                    String userAnswer = answerScanner.nextLine();
                    if (userAnswer.toLowerCase().equals("a") || userAnswer.toLowerCase().equals("b") || userAnswer.toLowerCase().equals("c")){
                        System.out.println("");
                        for (Answer a : q.getAnswerList()) {
                            if (userAnswer.toLowerCase().equals(a.getAnswerName().substring(0, 1))) {
                                this.answerId = String.valueOf(a.getAnswerId());
                                //System.out.print("Twoja kategoria to: "+showCategory()+"Czy chcesz szukac dalej?: ");
//                                String isContinue = answerScanner.nextLine();
//                                if(isContinue.equals("T")) {
                                   showQuestion(String.valueOf(a.getRelatedQuest()));
//                                }
//                                else {
//                                    break;
//                                }
                            }
                        }
                        break;
                    }
                    else {
                        System.out.print("Podałeś niepoprawną odpoowiedź, jescze raz: ");
                    }
                }
            }
        }

    }

    // Wyświetlenie wyniku - kategorii - po odpowiedzi na pytania
    //TODO ta metoda powinna zwrócić String z kategorią która będzie przekazana do metody wyszukiwania

    void showCategory() {
        Category category = new Category();
        List<Category> categoryList = category.getCategoryList();
        SearchCategory searchCategory = new SearchCategory();
        String id = "1";
        String catId;
        //String categoryResult = null;
        searchCategory.showQuestion(id);
        catId = searchCategory.getAnswerId();
        for (Category cat : categoryList) {
            if (catId.equals(String.valueOf(cat.getCategoryId()))) {
                System.out.println("Twoja kategoria Allegro to: \033[33m" + cat.getCategoryName()+"\033[0m");
          //      categoryResult = category.getCategoryName();
            }
        }
        //return categoryResult;
    }


//    void startQuiz(){
//        showQuestion("1");
//        showCategory();
//        System.out.println("Twoja kategoria Allegro to: \033[33m" +showCategory()+"\033[0m");
//    }
}
