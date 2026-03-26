package org.example.service;

import org.example.dao.QuestionDao;
import org.example.dao.QuestionDaoImpl;
import org.example.model.Question;

import java.util.List;
import java.util.Scanner;

public class QuestionService {
    Scanner s = new Scanner(System.in);
    QuestionDao qDao = new QuestionDaoImpl();
    public void addQuestion(){
        qDao.addQuestion(getQuestionFromUser());
    }
    public void updateQuestion(){
        qDao.updateQuestion(getQuestionFromUser());
    }
    public void viewQuestion(){
        List<Question> questionList = qDao.displayAll();
        for(Question q : questionList)
            System.out.println(q);
    }
    public Question getQuestionFromUser() {
        System.out.println("Enter question id: ");
        int id = s.nextInt();
        System.out.println("Enter question: ");
        s.nextLine();
        String qT = s.nextLine();
        System.out.println("Enter option A: ");
        String oA = s.nextLine();
        System.out.println("Enter option B: ");
        String oB = s.nextLine();
        System.out.println("Enter option C: ");
        String oC = s.nextLine();
        System.out.println("Enter option D: ");
        String oD = s.nextLine();
        System.out.println("Enter correct option: ");
        String correctO = s.nextLine();
        return new Question(id, qT, oA, oB, oC, oD, correctO);
    }
}
