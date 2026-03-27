package org.example;


import org.example.dao.MemberDao;
import org.example.dao.MemberDaoImpl;
import org.example.dao.QuestionDao;
import org.example.dao.QuestionDaoImpl;
import org.example.model.Member;
import org.example.model.Question;
import org.example.service.MemberService;
import org.example.service.QuestionService;
import org.example.util.DbConnection;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    static Connection con = DbConnection.getConnection();
    static MemberDao mDao = new MemberDaoImpl();
    static QuestionDao qDao = new QuestionDaoImpl();
    static MemberService mServ = new MemberService();
    static QuestionService qServ = new QuestionService();
    @BeforeAll
    public static void checkDB(){
        assertNotNull(con);
    }
    @Test
    public void memberDaoExist(){
        assertNotNull(mDao);
    }
    @Test
    public void questionDaoExist(){
        assertNotNull(qDao);
    }
    @Test
    public void memberServiceExist(){
        assertNotNull(mServ);
    }
    @Test
    public void questionServiceExist(){
        assertNotNull(qServ);
    }
    @Test
    public void createMember(){
        mDao.register(new Member(100, "Test", "Test@1234"));
        Member member = mDao.getMember(100);
        assertNotNull(member);
    }
    @Test
    public void createQuestion(){
        List<Question> qList = new ArrayList<>();
        qList = qDao.displayAll();
        int rows = qList.size();
        qDao.addQuestion(new Question(100, "Q1", "A", "B", "C", "D", "A"));
        qList = qDao.displayAll();
        assertEquals(rows + 1, qList.size());
    }
    @Test
    public void updateQuestions(){
        qDao.updateQuestion(new Question(100, "Q2", "A", "B", "C", "D", "D"));
        List<Question> qList = new ArrayList<>();
        qList = qDao.displayAll();
        for(Question q : qList){
            if(q.getQuestionText().equals("Q2")) {
                assertTrue(true);
                return;
            }
        }
        assertFalse(true);
    }

    @AfterAll
    public static void clearResource(){
        con = null;
        assertNull(con);
    }
}
