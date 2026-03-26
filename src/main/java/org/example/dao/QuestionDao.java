package org.example.dao;

import org.example.model.Question;

import java.util.List;

public interface QuestionDao{
    void addQuestion(Question q);

    void updateQuestion(Question q);

    List<Question> displayAll();
}
