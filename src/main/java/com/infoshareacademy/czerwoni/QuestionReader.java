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

public class QuestionReader {
    //private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private ArrayList<Question> questionArrayList = new ArrayList<>();
    ParseXML docXML = new ParseXML();

    ArrayList<Question> getQuestionList() {
        //try {

            //File fXmlFile = new File("Categories.xml");
            //DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Document doc = dBuilder.parse(fXmlFile);
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
//                System.out.println(k+": "+questionArrayList.get(k).getQuestionName());
//                for (int j=0;j<questionArrayList.get(k).getAnswerList().size();j++){
//                    System.out.println(k+":"+j+":"+questionArrayList.get(k).getAnswerList().get(j).getAnswerName());
//                }

            }

//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        catch (ParserConfigurationException e){
//            e.printStackTrace();
//        }
//        catch (SAXException e){
//            e.printStackTrace();
//        }
        return questionArrayList;
    }
}
