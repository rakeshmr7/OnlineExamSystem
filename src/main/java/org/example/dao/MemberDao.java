package org.example.dao;

import org.example.model.Member;
import org.example.model.Question;

import java.util.List;

public interface MemberDao {
    void register(Member member);
    Member getMember(int id);
    List<Question> takeExam();
}
