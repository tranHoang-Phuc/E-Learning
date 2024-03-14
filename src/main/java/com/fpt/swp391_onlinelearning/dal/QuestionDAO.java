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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        } finally {
            DBContext.close(connection);
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
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));

                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getRecentId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertAnswers(List<String> answerContents, int questionId, List<Boolean> isTrueArray) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO answer(content, questionId, isTrue) VALUES (?, ?, ?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            connection.setAutoCommit(false);

            // Lặp qua từng câu trả lời trong danh sách
            for (int i = 0; i < answerContents.size(); i++) {
                // Thêm câu trả lời vào batch
                stm.setString(1, answerContents.get(i));
                stm.setInt(2, questionId);
                stm.setBoolean(3, isTrueArray.get(i));
                stm.addBatch();
            }

            stm.executeBatch();

            connection.commit();
        } catch (SQLException ex) {
            try {

                connection.rollback();
            } catch (SQLException rollbackEx) {

            }
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                connection.setAutoCommit(true);
            } catch (SQLException autoCommitEx) {

            }
            // Đóng kết nối
            DBContext.close(connection);
        }
    }

    @Override
    public int insertQuestionAndGetId(String content, int lessonId) {
        Connection connection = DBContext.getConnection();
        String insertSql = "INSERT INTO question(content, lessonId) VALUES (?, ?)";
        String selectSql = "SELECT @@IDENTITY";
        int questionId = -1;
        try {
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setString(1, content);
            insertStatement.setInt(2, lessonId);
            insertStatement.executeUpdate();
            insertStatement.close();

            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            ResultSet rs = selectStatement.executeQuery();
            if (rs.next()) {
                questionId = rs.getInt(1);
            }
            selectStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }

        return questionId;
    }

    @Override
    public List<Question> getQuestionByTempId(int tempId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT q.questionId,q.content,q.lessonId\n"
                + "FROM question q, tempquestion tq\n"
                + "WHERE q.questionId=tq.questionId AND tq.tempId=?";
        List<Question> questionList = new ArrayList<>();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, tempId);
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
        } finally {
            DBContext.close(connection);
        }
        return null;
    }

    @Override
    public Map<Question, List<Answer>> getAllQuestionByLesson(int lessonId) {
        Connection connection = DBContext.getConnection();
        Map<Question, List<Answer>> questionTest = new LinkedHashMap<>();
        try {
            String questionSql = "SELECT questionId, content FROM question WHERE lessonId = ? AND isActivated = true";
            connection.setAutoCommit(false);
            PreparedStatement questionStm = connection.prepareStatement(questionSql);
            questionStm.setInt(1, lessonId);
            ResultSet rs = questionStm.executeQuery();
            while (rs.next()) {                
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                q.setContent(rs.getString("content"));
                
                String answerSql = "SELECT content, isTrue FROM answer where questionId = ?";
                PreparedStatement stm = connection.prepareStatement(answerSql);
                stm.setInt(1, q.getQuestionId());
                ResultSet rs1 = stm.executeQuery();
                List<Answer> answers = new ArrayList<>();
                while (rs1.next()) {                    
                    Answer a = new Answer();
                    a.setContent(rs1.getString("content"));
                    a.setIsTrue(rs1.getBoolean("isTrue"));
                    answers.add(a);
                }
                questionTest.put(q, answers);
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBContext.close(connection);

        }
        return questionTest;
    }

    @Override
    public void deleteQuestion(int questionId) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE question SET isActivated = false WHERE questionId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, questionId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
