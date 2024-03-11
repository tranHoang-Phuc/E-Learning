/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IChapterDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Lesson;
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
 * @author tran Hoang Phuc
 */
public class ChapterDAO implements IChapterDAO, IDAO<Chapter> {

    @Override
    public void addChapterAtPosition(String chapterName, int position, int courseId) {
        Connection connection = DBContext.getConnection();
        try {
            String sql = "INSERT INTO `chapter` (name, courseId) VALUES (?, ?)";
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, chapterName);
            stm.setInt(2, courseId);
            stm.executeUpdate();
            // chapterId
            String sqlGetChapterId = "SELECT @@Identity AS chapterId";
            PreparedStatement stmGetChapterId = connection.prepareStatement(sqlGetChapterId);
            ResultSet rs = stmGetChapterId.executeQuery();
            int chapterId = -1;
            if (rs.next()) {
                chapterId = rs.getInt("chapterId");
            }

            String sqlInsertSequence = "INSERT INTO `chaptersequence` (chapterId, sequence) VALUES(?, ?)";
            PreparedStatement stmInsertSequence = connection.prepareStatement(sqlInsertSequence);
            stmInsertSequence.setInt(1, chapterId);
            stmInsertSequence.setInt(2, position);
            stmInsertSequence.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBContext.close(connection);
        }
    }

    private List<Chapter> getChapterSequece(int courseId, int sequence, String position) {
        Connection connection = DBContext.getConnection();
        List<Chapter> chapters = new ArrayList<>();
        String sql = "";
        if (position.equals("before")) {
            sql = "SELECT cs.chapterId, sequence FROM chaptersequence cs JOIN chapter c \n"
                    + "ON cs.chapterId = c.chapterId JOIN course co\n"
                    + "ON co.courseId = c.courseId  WHERE co.courseId = ? AND sequence >= ?";
        } else {
            sql = "SELECT cs.chapterId, sequence FROM chaptersequence cs JOIN chapter c \n"
                    + "ON cs.chapterId = c.chapterId JOIN course co\n"
                    + "ON co.courseId = c.courseId  WHERE co.courseId = ? AND sequence > ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            if (!position.equals("before")) {
                stm.setInt(1, courseId);
                stm.setInt(2, sequence);
            } else {
                stm.setInt(1, courseId);
                stm.setInt(2, sequence);

            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Chapter c = new Chapter();
                c.setChapterId(rs.getInt("chapterId"));
                c.setSequence(rs.getInt("sequence"));
                chapters.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chapters;
    }

    @Override
    public String updateChapterSequence(int chapterId, int sequence, String position, boolean isFirst, int courseId) {
        Connection connection = DBContext.getConnection();
        List<Chapter> chapters = new ChapterDAO().getChapterSequece(courseId, sequence, position);
        try {
            connection.setAutoCommit(false);
            if (!chapters.isEmpty()) {
                List<Chapter> afterHandle = new ArrayList<>();
                if (position.endsWith("before")) {
                    for (Chapter chapter : chapters) {
                        Chapter c = new Chapter();
                        c.setChapterId(chapterId);
                        c.setSequence(chapter.getSequence() + 1);
                        afterHandle.add(c);
                    }
                } else {
                    for (Chapter chapter : chapters) {
                        Chapter c = new Chapter();
                        c.setChapterId(chapterId);
                        c.setSequence(chapter.getSequence() + 1);
                        afterHandle.add(c);
                    }
                }

                for (int i = 0; i < afterHandle.size(); i++) {
                    String sqlHandleSequence = "UPDATE chaptersequence SET sequence = ? WHERE chapterId = ? AND sequence = ?";
                    PreparedStatement sequenceStm = connection.prepareStatement(sqlHandleSequence);
                    sequenceStm.setInt(1, afterHandle.get(i).getSequence());
                    sequenceStm.setInt(2, chapters.get(i).getChapterId());
                    sequenceStm.setInt(3, chapters.get(i).getSequence());
                    sequenceStm.executeUpdate();
                }
            }
            connection.commit();
            return "middle";
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Chapter> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Chapter get(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT chapterId, name FROM chapter WHERE chapterId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Chapter c = new Chapter();
                c.setChapterId(rs.getInt("chapterId"));
                c.setName(rs.getString("name"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Chapter t) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE chapter SET `name` = ? WHERE chapterId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, t.getName());
            stm.setInt(2, t.getChapterId());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean insert(Chapter t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        System.out.println(new ChapterDAO().delete(8));
    }
    @Override
    public boolean delete(int id) {
        Connection connection = DBContext.getConnection();
        try {
            connection.setAutoCommit(false);
            String sqlSequence = "DELETE FROM chaptersequence WHERE chapterId = ?";
            PreparedStatement sequenceStm = connection.prepareStatement(sqlSequence);
            sequenceStm.setInt(1, id);
            sequenceStm.executeUpdate();

            List<Lesson> lessons = new ArrayList<>();
            String sqlLessons = "SELECT lessonId FROM lesson WHERE chapterId = ?";
            PreparedStatement lessonStm = connection.prepareStatement(sqlLessons);
            lessonStm.setInt(1, id);
            ResultSet rs = lessonStm.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                l.setLessonId(rs.getInt("lessonId"));
                lessons.add(l);
            }
            if (!lessons.isEmpty()) {
                for (Lesson lesson : lessons) {
                    String sqlLessonseq = "DELETE FROM lessonsequence where lessonId = ?";
                    PreparedStatement lessonSeqStm = connection.prepareStatement(sqlLessonseq);
                    lessonSeqStm.setInt(1, lesson.getLessonId());
                    lessonSeqStm.executeUpdate();
                }
            }
            connection.commit();
            return true;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBContext.close(connection);
        }
        return false;
    }

}
