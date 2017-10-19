package com.infoshareacademy.czerwoni;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;

class QuestionReader {
    private ArrayList<Question> questionArrayList = new ArrayList<>();
    private ParseXML docXML = new ParseXML();

    ArrayList<Question> getQuestionList() {
            Document doc = docXML.getXMLDocument();
            NodeList questList = doc.getElementsByTagName("quest-item");

            for (int k=0;k<questList.getLength();k++) {
                Node questItem = questList.item(k);
                Element quest = (Element) questItem;
                Question question = new Question();
                question.setQuestionId(Integer.parseInt(quest.getAttribute("id")));
                question.setQuestionName(quest.getAttribute("question"));
                ArrayList<Answer> answerArrayList = new ArrayList<>();
                NodeList answerList = quest.getChildNodes();
                for (int i = 0; i < answerList.getLength(); i++) {
                    Node answerItem = answerList.item(i);
                    if (answerItem.getNodeType() == Node.ELEMENT_NODE) {
                        Element answer = (Element) answerItem;
                        Answer answerQ = new Answer();
                        answerQ.setAnswerName(answer.getTextContent());
                        answerQ.setRelatedQuest(Integer.parseInt(answer.getAttribute("goto-quest-id")));
                        answerArrayList.add(answerQ);
                    }
                }
                question.setAnswerList(answerArrayList);
                questionArrayList.add(question);
            }
        return questionArrayList;

    }
}
