package com.infoshareacademy.czerwoni;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionReader {
    public static void main(String args[]) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Question question = new Question();
        Answer answerQ = new Answer();
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        ArrayList<Question> questionArrayList = new ArrayList<>();
        ArrayList<Answer> answerArrayList = new ArrayList<>();
        try {

            File fXmlFile = new File("Categories.xml");
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList questList = doc.getElementsByTagName("quest-item");
            NodeList catList = doc.getElementsByTagName("cat-item");

            for (int k=0;k<questList.getLength();k++) {
                Node questItem = questList.item(k);
                Element quest = (Element) questItem;

                question.setQuestionId(Integer.parseInt(quest.getAttribute("id")));
                question.setQuestionName(quest.getAttribute("question"));

                //System.out.println(quest.getAttribute("id"));
                //System.out.println(quest.getAttribute("question"));
                NodeList answerList = quest.getChildNodes();

                for (int i = 0; i < answerList.getLength(); i++) {
                    Node answerItem = answerList.item(i);
                    if (answerItem.getNodeType() == Node.ELEMENT_NODE) {
                        Element answer = (Element) answerItem;

                        answerQ.setAnswerName(answer.getTextContent());
                        answerQ.setRelatedQuest(Integer.parseInt(answer.getAttribute("goto-quest-id")));
                        answerArrayList.add(answerQ);
                        //System.out.println(answer.getTextContent());
                    }
                }
                question.setAnswerList(answerArrayList);
                questionArrayList.add(question);

            }

            for (Question q:questionArrayList) {
                System.out.println(q.getQuestionName());
//                for (int i=0;i<questionArrayList.get(i).getAnswerList().size();i++) {
//                    System.out.println(questionArrayList.get(i).getAnswerList().get(i).getAnswerName());
//                }
            }




























//                questionArrayList.get(k).setQuestionId(Integer.getInteger(quest.getAttribute("id")));
//                questionArrayList.get(k).setQuestionName(quest.getTextContent());

//                System.out.println("ID: "+questionArrayList.get(k).getQuestionId());

//                for (int i = 0; i < catList.getLength(); i++) {
//                    Node catItem = catList.item(i);
//                    if (catItem.getNodeType() == Node.ELEMENT_NODE) {
//                    Element category = (Element) catItem;
//                        NodeList itemList = category.getChildNodes();
//                        for (int j = 0; j < itemList.getLength(); j++) {
//                            Node details = itemList.item(j);
//                            if (details.getNodeType() == Node.ELEMENT_NODE) {
//                                Element itemName = (Element) details;
//                                switch (itemName.getTagName()){
//                                    case "cat-item-id" : {
//                                        categoryList.get(j).setCategoryId(Integer.getInteger(itemName.getTextContent()));
//                                    }
//                                    break;
//                                    case "cat-item-name" : {
//                                        categoryList.get(j).setCategoryName(itemName.getTextContent());
//                                    }
//                                    break;
//                                    case "cat-item-parent" : {
//                                        categoryList.get(j).setCategoryParent(Integer.getInteger(itemName.getTextContent()));
//                                    }
//                                    break;
//                                    case "cat-item-position" : {
//                                        categoryList.get(j).setCategoryPosition(Integer.getInteger(itemName.getTextContent()));
//                                    }
//                                    break;
//                                    case "cat-item-visible" : {
//                                        categoryList.get(j).setCategoryVisible(Boolean.getBoolean(itemName.getTextContent()));
//                                    }
//                                    break;
//                                    case "quest-goto-id" : {
//                                        questionArrayList.get(k).getAnswerList().get(j).setRelatedQuest(Integer.getInteger(itemName.getTextContent()));
//                                    }
//                                    break;
//                                    case "cat-item-answer" : {
//                                        questionArrayList.get(k).getAnswerList().get(j).setAnswerName(itemName.getTextContent());
//                                        //questionArrayList.get(k).getAnswerList().get(j).setRelatedQuest(Integer.getInteger(itemName.getTextContent()));
//                                    }
//                                    break;
//                                }
                                //System.out.println(itemName.getTagName()+" : "+itemName.getTextContent());

//                                if(quest.getAttribute("id").equals(itemName.getAttribute("question"))) {
//
//                                    System.out.println(itemName.getTextContent());
//
//
//                                }
//
//                            }
//                        }
                    //}
                //}

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (SAXException e){
            e.printStackTrace();
        }
    }

}
