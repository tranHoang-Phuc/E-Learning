/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ILessonDAO;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Lesson;
import com.fpt.swp391_onlinelearning.model.LessonType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class LessonDAO implements IDAO<Lesson>, ILessonDAO {

    @Override
    public List<Lesson> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lesson get(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT  lessonId,  name,  chapterId,  typeId,  duration, content\n"
                + "FROM `swp391_onlinelearning`.`lesson` l \n"
                + "WHERE lessonId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                l.setName(rs.getString("name"));

                Chapter c = new Chapter();
                c.setChapterId(rs.getInt("chapterId"));

                LessonType lt = new LessonType();
                lt.setTypeId(rs.getInt("typeId"));

                l.setChapter(c);
                l.setType(lt);
                l.setDuration(rs.getInt("duration"));
                l.setContent(rs.getString("content"));
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(Lesson t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "DELETE FROM lessonsequence WHERE lessonId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return false;
    }

    @Override
    public Map<Chapter, List<Lesson>> getLessonByCourse(int courseId) {
        Connection connection = DBContext.getConnection();
        Map<Chapter, List<Lesson>> chapterMappingLessons = new LinkedHashMap<>();
        List<Chapter> chapters = new ArrayList<>();
        String chapterSql = "SELECT c.chapterId, name, courseId, sequence "
                + "FROM `swp391_onlinelearning`.`chapter` c JOIN `swp391_onlinelearning`.`chaptersequence` cs "
                + "ON c.`chapterId` = cs.`chapterId` "
                + "WHERE courseId = ? ORDER BY cs.sequence, cs.chapterId";
        String sql = "SELECT l.lessonId,  name,  l.chapterId,  typeId,  duration, content, ls.sequence\n"
                + "FROM `swp391_onlinelearning`.`lesson` l JOIN  `swp391_onlinelearning`.`lessonsequence` ls\n"
                + "ON l.lessonId = ls.lessonId  JOIN chaptersequence cs ON l.chapterId = cs.chapterId "
                + "WHERE l.chapterId = ? ORDER BY cs.sequence ,ls.sequence";
        try {
            PreparedStatement chapterStm = connection.prepareStatement(chapterSql);
            chapterStm.setInt(1, courseId);
            ResultSet chapterResultSet = chapterStm.executeQuery();
            while (chapterResultSet.next()) {
                Chapter c = new Chapter();
                c.setChapterId(chapterResultSet.getInt("chapterId"));
                c.setName(chapterResultSet.getString("name"));
                c.setSequence(chapterResultSet.getInt("sequence"));
                chapters.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!chapters.isEmpty()) {
            for (Chapter chapter : chapters) {
                try {
                    List<Lesson> lessons = new ArrayList<>();
                    PreparedStatement lessonStm = connection.prepareStatement(sql);
                    lessonStm.setInt(1, chapter.getChapterId());
                    ResultSet rs = lessonStm.executeQuery();
                    while (rs.next()) {
                        Lesson l = new Lesson();
                        l.setSequence(rs.getInt("sequence"));
                        l.setLessonId(rs.getInt("lessonId"));
                        l.setChapter(chapter);
                        l.setName(rs.getString("name"));
                        LessonType lt = new LessonType();
                        lt.setTypeId(rs.getInt("typeId"));
                        l.setType(lt);
                        l.setDuration(rs.getInt("duration"));
                        l.setContent(rs.getString("content"));
                        lessons.add(l);
                    }
                    chapterMappingLessons.put(chapter, lessons);
                } catch (SQLException ex) {
                    Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            DBContext.close(connection);
        }
        DBContext.close(connection);
        return chapterMappingLessons;
    }

    @Override
    public int getCurrentLesson(int courseId, int userId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MAX(ul.lessonId) AS current FROM swp391_onlinelearning.userlesson ul\n"
                + "JOIN swp391_onlinelearning.lesson l \n"
                + "ON ul.lessonId = l.lessonId\n"
                + "JOIN swp391_onlinelearning.chapter ch\n"
                + "ON l.chapterId = ch.chapterId\n"
                + "JOIN swp391_onlinelearning.course c \n"
                + "ON ch.courseId = c.courseId\n"
                + "WHERE ul.userId= ? AND c.courseId = ? AND ul.isFinished = 1";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, courseId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("current");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public int getNextLesson(int userId, int current) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MIN(lessonId) AS nextLesson FROM swp391_onlinelearning.userlesson\n"
                + "WHERE lessonId > ? AND userId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, current);
            stm.setInt(2, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("nextLesson");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public int getFirstLessonId(int courseId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MIN(l.lessonId) AS firstLesson FROM swp391_onlinelearning.course c\n"
                + "JOIN swp391_onlinelearning.chapter ch\n"
                + "ON c.courseId = ch.courseId\n"
                + "JOIN swp391_onlinelearning.lesson l\n"
                + "ON ch.chapterId = l.chapterId";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("firstLesson");
            }

        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public int getLastLessonId(int courseId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MAX(l.lessonId) AS lastLesson FROM swp391_onlinelearning.course c\n"
                + "JOIN swp391_onlinelearning.chapter ch\n"
                + "ON c.courseId = ch.courseId\n"
                + "JOIN swp391_onlinelearning.lesson l\n"
                + "ON ch.chapterId = l.chapterId";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("lastLesson");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public int getPreviousLesson(int userId, int current) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT MAX(lessonId) AS previousLesson FROM swp391_onlinelearning.userlesson\n"
                + "WHERE lessonId < ? AND userId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, current);
            stm.setInt(2, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("previousLesson");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return 0;
    }

    @Override
    public List<Lesson> getLessonsByCourse(int courseId) {
        List<Lesson> lessons = new ArrayList<>();
        Connection connection = DBContext.getConnection();
        String sql = "SELECT  l.`lessonId`,  l.`name`,  l.`chapterId`,  l.`typeId`,  l.`duration`,l.content \n"
                + "FROM `swp391_onlinelearning`.`lesson` l\n"
                + "JOIN swp391_onlinelearning.chapter ch \n"
                + "ON l.chapterId = ch.chapterId\n"
                + "JOIN swp391_onlinelearning.course c\n"
                + "ON ch.courseId = c.courseId\n"
                + "WHERE c.courseId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, courseId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                Chapter chapter = new Chapter();
                chapter.setChapterId(rs.getInt("chapterId"));
                l.setChapter(chapter);
                l.setName(rs.getString("name"));
                LessonType lt = new LessonType();
                lt.setTypeId(rs.getInt("typeId"));
                l.setType(lt);
                l.setDuration(rs.getInt("duration"));
                l.setContent(rs.getString("content"));
                lessons.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return lessons;
    }

    @Override
    public void addLessonAtPosition(String lessonName, int position, int chapterId, int typeId, int duration, String content) {
        Connection connection = DBContext.getConnection();
        try {
            connection.setAutoCommit(false);
            String intertSql = "INSERT INTO lesson (name, chapterId, typeId, duration, content) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement lessonStm = connection.prepareStatement(intertSql);
            lessonStm.setString(1, lessonName);
            lessonStm.setInt(2, chapterId);
            lessonStm.setInt(3, typeId);
            lessonStm.setInt(4, duration);
            if (typeId != 3) {
                lessonStm.setString(5, content);
            } else {
                lessonStm.setString(5, "");
            }
            lessonStm.executeUpdate();

            // getLessonId
            int lessonId = -1;
            String getLesson = "SELECT @@Identity AS lessonId";
            PreparedStatement getLessonStm = connection.prepareStatement(getLesson);
            ResultSet rs = getLessonStm.executeQuery();
            if (rs.next()) {
                lessonId = rs.getInt("lessonId");
            }

            String sequenceSql = "INSERT INTO lessonsequence (lessonId, sequence) VALUES (?, ?)";
            PreparedStatement sequenceStm = connection.prepareStatement(sequenceSql);
            sequenceStm.setInt(1, lessonId);
            sequenceStm.setInt(2, position);
            sequenceStm.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException ex) {
                Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBContext.close(connection);
        }

    }

    private List<Lesson> getLessonSequence(int chapterId, int sequence, String position) {
        Connection connection = DBContext.getConnection();
        List<Lesson> lessons = new ArrayList<>();
        String sql = "";
        if (position.equals("before")) {
            sql = "SELECT ls.lessonId, sequence, c.chapterId FROM lessonsequence ls\n"
                    + "JOIN lesson l ON ls.lessonId = l.lessonId \n"
                    + "JOIN chapter c ON l.chapterId = c.chapterId\n"
                    + "WHERE c.chapterId = ? AND ls.sequence >= ?";
        } else {
            sql = "SELECT ls.lessonId, sequence, c.chapterId FROM lessonsequence ls\n"
                    + "JOIN lesson l ON ls.lessonId = l.lessonId \n"
                    + "JOIN chapter c ON l.chapterId = c.chapterId\n"
                    + "WHERE c.chapterId = ? AND ls.sequence > ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, chapterId);
            stm.setInt(2, sequence);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                l.setSequence(rs.getInt("sequence"));
                lessons.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessons;
    }

    public static void main(String[] args) {
        new LessonDAO().updateArticle(3, "Practice", "Update");
    }

    @Override
    public String updateChapterSequence(int lessonId, int sequence, String position, boolean isFirst, int chapterId) {
        Connection connection = DBContext.getConnection();
        List<Lesson> lessons = new LessonDAO().getLessonSequence(chapterId, sequence, position);
        try {
            connection.setAutoCommit(false);
            if (!lessons.isEmpty()) {
                List<Lesson> afterHanlde = new ArrayList<>();

                for (Lesson lesson : lessons) {
                    Lesson l = new Lesson();
                    l.setLessonId(lesson.getLessonId());
                    l.setSequence(lesson.getSequence() + 1);
                    afterHanlde.add(l);
                }

                for (int i = 0; i < afterHanlde.size(); i++) {
                    String sqlUpdate = "UPDATE lessonsequence SET sequence = ? WHERE lessonId =? AND sequence =?";
                    PreparedStatement stm = connection.prepareStatement(sqlUpdate);
                    stm.setInt(1, afterHanlde.get(i).getSequence());
                    stm.setInt(2, lessons.get(i).getLessonId());
                    stm.setInt(3, lessons.get(i).getSequence());
                    stm.executeUpdate();
                }
            }
            connection.commit();
            return "middle";
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "first";
    }

    @Override
    public void updateArticle(int lessonId, String lessonName, String content) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE lesson SET `name` = ?, `content` = ? WHERE lessonId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lessonName);
            stm.setString(2, content);
            stm.setInt(3, lessonId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
