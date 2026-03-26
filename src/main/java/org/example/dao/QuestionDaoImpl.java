package org.example.dao;

import org.example.model.Question;
import org.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao{
    Connection con;
    PreparedStatement pst;
    public QuestionDaoImpl(){
        try{
            con = DbConnection.getConnection();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void addQuestion(Question q){
        String qu = "INSERT INTO question VALUES(?, ?, ?, ?, ?, ?, ?);";
        try{
            pst = con.prepareStatement(qu);
            pst.setInt(1, q.getQuestionId());
            pst.setString(2, q.getQuestionText());
            pst.setString(3, q.getOptionA());
            pst.setString(4, q.getOptionB());
            pst.setString(5, q.getOptionC());
            pst.setString(6, q.getOptionD());
            pst.setString(7, q.getCorrectAnswer());
            int row = pst.executeUpdate();
            if(row > 0) System.out.println("Question added!!");
            else System.out.println("Question not added!!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateQuestion(Question q){
        String qu = "UPDATE question SET questionText = ?, optionA = ?, optionB = ?, "
                    + "optionC = ?, optionD = ?, correctAnswer = ? WHERE questionId = ?;";
        try{
            pst = con.prepareStatement(qu);
            pst.setString(1, q.getQuestionText());
            pst.setString(2, q.getOptionA());
            pst.setString(3, q.getOptionB());
            pst.setString(4, q.getOptionC());
            pst.setString(5, q.getOptionD());
            pst.setString(6, q.getCorrectAnswer());
            pst.setInt(7, q.getQuestionId());
            int row = pst.executeUpdate();
            if(row > 0) System.out.println("Question updated!!");
            else System.out.println("Question id not found!!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Question> displayAll(){
        List<Question> qList = new ArrayList<>();
        String q = "SELECT * FROM question;";
        try{
            pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                qList.add(new Question(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return qList;
    }
}
