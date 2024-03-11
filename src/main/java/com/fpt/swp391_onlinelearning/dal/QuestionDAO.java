/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IQuestionDAO;
import com.fpt.swp391_onlinelearning.model.Answer;
import com.fpt.swp391_onlinelearning.model.Lesson;
import com.fpt.swp391_onlinelearning.model.Question;
import com.fpt.swp391_onlinelearning.model.TempQuiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phuc2
 */
public class QuestionDAO implements IDAO<Question>, IQuestionDAO {

    @Override
    public List<Question> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Question get(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT questionId,content,lessonId FROM question\n"
                + "WHERE questionId=?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                q.setContent(rs.getString("content"));
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                q.setLesson(l);
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public boolean update(Question t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Question t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Question> getCurrentAttemptQuestion(int userId, int lessonId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT quiz.tempId,ques.questionId, question.content, question.lessonId\n"
                + "FROM tempquiz AS quiz, tempquestion AS ques, question\n"
                + "WHERE quiz.tempId=(SELECT tempId FROM tempquiz ORDER BY tempId DESC LIMIT 1) AND quiz.tempId=ques.tempId AND ques.questionId=question.questionId AND quiz.userId=? AND quiz.lessonId=?";
        List<Question> questionList = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, lessonId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                q.setContent(rs.getString("content"));
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                q.setLesson(l);
                questionList.add(q);
            }
            return questionList;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Question getQuestionByAnswer(Answer a) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT a.answerId, q.questionId\n"
                + "FROM answer AS a, question AS q\n"
                + "WHERE a.questionId=q.questionId AND a.answerId=?";
        
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, a.getAnswerId());
            ResultSet rs= stm.executeQuery();
            if(rs.next())
            {
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
