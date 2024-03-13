/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IAnswerDAO;
import com.fpt.swp391_onlinelearning.model.Answer;
import com.fpt.swp391_onlinelearning.model.Question;
import com.fpt.swp391_onlinelearning.model.TempQuiz;
import com.fpt.swp391_onlinelearning.model.User;
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
public class AnswerDAO implements IAnswerDAO {

    @Override
    public List<Answer> getAnswerByQuestion(int questionId) {
        Connection connection = DBContext.getConnection();
        List<Answer> answers = new ArrayList<>();
        String sql = "SELECT answerId,content,questionId,isTrue FROM answer WHERE questionId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Answer a = new Answer();
                a.setAnswerId(rs.getInt("answerId"));
                a.setContent(rs.getString("content"));
                a.setIsTrue(rs.getBoolean("isTrue"));
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                a.setQuestion(q);
                answers.add(a);
            }

            return answers;
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public void insertQuizAnswer(Answer a, TempQuiz t) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO tempanswer (tempId, answerId)\n"
                + "VALUES(?,?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, t.getTempId());
            stm.setInt(2, a.getAnswerId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public void deleteRemainAnswer(Question q, TempQuiz t) {
        Connection connection = DBContext.getConnection();
        String sql = "DELETE FROM tempanswer \n"
                + "WHERE answerid in (SELECT answerId FROM answer WHERE questionId=?) AND tempId IN (SELECT tempId FROM tempquiz WHERE tempId=?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, q.getQuestionId());
            stm.setInt(2, t.getTempId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public List<Answer> getAnswerInTemp(int tempId, int questionId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT a.answerId, a.content,a.isTrue,a.questionId\n"
                + "FROM answer AS a, tempanswer AS ta, question AS q\n"
                + "WHERE ta.tempId=? AND q.questionId=a.questionId AND a.answerId=ta.answerId AND q.questionId=?";
        List<Answer> answerList= new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, tempId);
            stm.setInt(2, questionId);
            ResultSet rs= stm.executeQuery();
            while(rs.next())
            {
                Answer a= new Answer();
                a.setAnswerId(rs.getInt("answerId"));
                a.setContent(rs.getString("content"));
                a.setIsTrue(rs.getBoolean("isTrue"));
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                a.setQuestion(q);
                answerList.add(a);
            }
            return answerList;
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

}
