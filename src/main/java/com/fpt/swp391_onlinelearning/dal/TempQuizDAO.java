/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.ITempQuizDAO;
import com.fpt.swp391_onlinelearning.model.Lesson;
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
public class TempQuizDAO implements ITempQuizDAO {

    @Override
    public void insertRandomTempQuestion(TempQuiz quiz, int numberOfQuestion) {
        Connection connection = DBContext.getConnection();
        try {
            
            connection.setAutoCommit(false);
            
            String numQuestSql = "SELECT COUNT(*) AS num FROM question where lessonId = ?";
            PreparedStatement numQuestStm = connection.prepareStatement(numQuestSql);
            numQuestStm.setInt(1, quiz.getLesson().getLessonId());
            ResultSet rs = numQuestStm.executeQuery();
            if (rs.next()) {
                if (rs.getInt("num") >= 20) {
                    numberOfQuestion = 20;
                } else {
                    numberOfQuestion = rs.getInt("num");
                }
            }
            String sql = "INSERT INTO tempquestion (tempId, questionId)\n"
                    + "SELECT \n"
                    + "    (SELECT tempId FROM tempQuiz WHERE lessonId = ? AND userId = ? ORDER BY tempId DESC LIMIT 1),\n"
                    + "    q.questionId\n"
                    + "FROM (\n"
                    + "    SELECT questionId\n"
                    + "    FROM question\n"
                    + "    WHERE lessonId = ?\n"
                    + "    ORDER BY RAND()\n"
                    + "    LIMIT ?\n"
                    + ") AS q\n"
                    + "GROUP BY q.questionId;";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quiz.getLesson().getLessonId());
            stm.setInt(2, quiz.getUser().getUserId());
            stm.setInt(3, quiz.getLesson().getLessonId());
            stm.setInt(4, numberOfQuestion);
            stm.executeUpdate();
            
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(TempQuizDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(TempQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(TempQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBContext.close(connection);
        }

    }

    @Override
    public void insertTempQuiz(TempQuiz quiz) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "INSERT INTO tempquiz (userId, lessonId, result)\n"
                    + "VALUES(?,?,-1)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quiz.getUser().getUserId());
            stm.setInt(2, quiz.getLesson().getLessonId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TempQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TempQuiz getLastUserTempQuiz(int userId, int lessonId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT quiz.tempId,quiz.result,quiz.userId,quiz.lessonId\n"
                + "FROM tempquiz AS quiz\n"
                + "WHERE quiz.tempId=(SELECT tempId FROM tempquiz ORDER BY tempId DESC LIMIT 1) AND quiz.userId=? AND quiz.lessonId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, lessonId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                TempQuiz tq = new TempQuiz();
                tq.setTempId(rs.getInt("tempId"));
                tq.setResult(rs.getFloat("result"));
                User u = new User();
                u.setUserId(rs.getInt("userId"));
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                tq.setLesson(l);
                tq.setUser(u);
                return tq;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TempQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateResult(TempQuiz t) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "UPDATE tempquiz\n"
                    + "SET result=?\n"
                    + "WHERE tempId=?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setFloat(1, t.getResult());
            stm.setInt(2, t.getTempId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TempQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TempQuiz> getTempQuizsByUserLesson(int userId, int lessonId) {
        Connection connection = DBContext.getConnection();
        List<TempQuiz> tempQuizs = new ArrayList<>();
        String sql = "SELECT tempId,userId,lessonId, result\n"
                + "FROM tempquiz\n"
                + "WHERE userId=? and lessonId=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, lessonId);
            ResultSet rs= stm.executeQuery();
            while(rs.next())
            {
                TempQuiz tq = new TempQuiz();
                tq.setTempId(rs.getInt("tempId"));
                tq.setResult(rs.getFloat("result"));
                User u = new User();
                u.setUserId(rs.getInt("userId"));
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                tq.setLesson(l);
                tq.setUser(u);
                tempQuizs.add(tq);
            }
            return tempQuizs;
        } catch (SQLException ex) {
            Logger.getLogger(TempQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
