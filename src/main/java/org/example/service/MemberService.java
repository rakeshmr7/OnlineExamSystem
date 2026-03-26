package org.example.service;

import org.example.dao.MemberDao;
import org.example.dao.MemberDaoImpl;
import org.example.dao.QuestionDao;
import org.example.dao.QuestionDaoImpl;
import org.example.model.Member;
import org.example.model.Question;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    Scanner s = new Scanner(System.in);
    MemberDao mDao = new MemberDaoImpl();
    QuestionDao qDao = new QuestionDaoImpl();
    public void register(){
        System.out.println("Enter userId: ");
        int id = s.nextInt();
        s.nextLine();
        System.out.println("Enter name: ");
        String name = s.nextLine();
        System.out.println("Enter email: ");
        String email = s.nextLine();
        Member member = new Member(id, name, email);
        mDao.register(member);
    }
    public void takeExam(){
        System.out.println("Enter id: ");
        int id = s.nextInt();
        s.nextLine();
        Member member = mDao.getMember(id);
        if(member == null) System.out.println("Member not found!!");
        else{
            System.out.println("Id: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Answer all questions:");
            List<Question> qList = qDao.displayAll();
            int totMark = 0;
            int mark = 0;
            int qNo = 0;
            for(Question q : qList){
                totMark++;
                System.out.println(++qNo + ". " + q.getQuestionText());
                System.out.println("A. " + q.getOptionA());
                System.out.println("B. " + q.getOptionB());
                System.out.println("C. " + q.getOptionC());
                System.out.println("D. " + q.getOptionD());
                System.out.println("Enter option(A/B/C/D): ");
                String op = s.nextLine();
                if(q.getCorrectAnswer().toLowerCase().equals(op.toLowerCase()))
                    mark++;
            }
            System.out.println("Your score: " + mark + "/" + totMark);
        }
    }
}
