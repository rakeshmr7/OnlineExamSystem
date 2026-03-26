package org.example.dao;

import org.example.model.Member;
import org.example.model.Question;
import org.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao{
    Connection con;
    PreparedStatement pst;
    public MemberDaoImpl(){
        try{
            con = DbConnection.getConnection();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void register(Member member){
        String q = "INSERT INTO member VALUES(?, ?, ?);";
        try{
            pst = con.prepareStatement(q);
            pst.setInt(1, member.getMemberId());
            pst.setString(2, member.getName());
            pst.setString(3, member.getEmail());
            int row = pst.executeUpdate();
            if(row > 0) System.out.println("Member registered!!");
            else System.out.println("Member nor registered!!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Member getMember(int id){
        Member member = null;
        String q = "SELECT * FROM member WHERE userId = ?;";
        try{
            pst = con.prepareStatement(q);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                member = new Member(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public List<Question> takeExam(){
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
