/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.model.CourseCategory;
import com.fpt.swp391_onlinelearning.model.CourseRegistration;
import com.fpt.swp391_onlinelearning.model.Duration;
import com.fpt.swp391_onlinelearning.model.Language;
import com.fpt.swp391_onlinelearning.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseRegistrationDAO;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseRegistrationDAO implements IDAO<CourseRegistration>, ICourseRegistrationDAO {

    @Override
    public List<CourseRegistration> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CourseRegistration get(int id) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT cg.registerId,c.courseId,a.accId,a.email,u.userId,u.name AS username, u.gender, u.dob, u.phone, u.img AS userimg, u.address, u.postCode,u.balance, c.name AS coursename, l.name AS level,\n"
                + "la.name AS language, c.img AS courseimg, c.description, author.name AS authorname,author.img AS authorimg,\n"
                + "cc.name AS category, d.name AS duration, cg.createdTime, c.price AS cost\n"
                + "FROM account a JOIN user u ON a.accId = u.accId\n"
                + "JOIN courseregistration cg ON cg.userId = u.userId\n"
                + "JOIN course c ON c.courseId = cg.courseId\n"
                + "JOIN coursecategory cc ON cc.courseCategoryId = c.courseCategoryId\n"
                + "JOIN duration d ON d.durationId = c.durationId\n"
                + "JOIN level l ON l.levelId = c.levelId\n"
                + "JOIN language la ON la.languageId = c.languageId\n"
                + "JOIN user author ON c.authorId = author.userId\n"
                + "WHERE cg.registerId = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                CourseRegistration cr = new CourseRegistration();
                Account acc = new Account();
                acc.setAccId(rs.getInt("accId"));
                acc.setEmail(rs.getString("email"));
                User user = new User();
                user.setAccount(acc);
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("username"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));
                user.setImg(rs.getString("userimg"));
                user.setAddress(rs.getString("address"));
                user.setPostCode(rs.getString("postCode"));
                user.setBalance(rs.getLong("balance"));
                cr.setUser(user);
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setName(rs.getString("coursename"));
                com.fpt.swp391_onlinelearning.model.Level level = new com.fpt.swp391_onlinelearning.model.Level();
                level.setName(rs.getString("level"));
                course.setLevel(level);
                Language language = new Language();
                language.setName(rs.getString("language"));
                course.setLanguage(language);
                course.setImg(rs.getString("courseimg"));
                course.setDescription(rs.getString("description"));
                User author = new User();
                author.setImg(rs.getString("authorimg"));
                author.setName(rs.getString("authorname"));
                course.setAuthor(author);
                CourseCategory cc = new CourseCategory();
                cc.setName(rs.getString("category"));
                course.setCategory(cc);
                Duration duration = new Duration();
                duration.setName(rs.getString("duration"));
                course.setDuration(duration);
                course.setPrice(rs.getLong("cost"));
                cr.setCourse(course);
                cr.setCreatedTime(rs.getDate("createdTime"));
                return cr;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DBContext.close(connection);
        }
        return null;

    }

    @Override
    public boolean update(CourseRegistration t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(CourseRegistration t) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`courseregistration` "
                + "(`userId`, `courseId`, `createdTime`) VALUES (?, ?, NOW());";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, t.getUser().getUserId());
            stm.setInt(2, t.getCourse().getCourseId());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CourseRegistration> getRegisterdCourse(int id) {
        List<CourseRegistration> courseRegisterations = new ArrayList<>();
        Connection connection = DBContext.getConnection();
        String sql = "SELECT `registerId`, `userId`, `courseId` , `createdTime` "
                + "FROM `swp391_onlinelearning`.`courseregistration` "
                + "WHERE `userId` = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CourseRegistration courseRegisteration = new CourseRegistration();
                courseRegisteration.setCourseRegisterationId(rs.getInt("registerId"));
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                courseRegisteration.setUser(user);
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                courseRegisteration.setCourse(course);
                courseRegisterations.add(courseRegisteration);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DBContext.close(connection);
        }
        return courseRegisterations;
    }

    public static void main(String[] args) {
        System.out.println(new CourseRegistrationDAO().getRegisterdCourse(1).size());
    }

    @Override
    public int countSearchRecord(String email, String courseName, int category, int duration, Date startTime, Date endTime) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT COUNT(*) AS numRegCourse\n"
                + "FROM account a JOIN user u ON a.accId = u.accId\n"
                + "JOIN courseregistration cg ON cg.userId = u.userId\n"
                + "JOIN course c ON c.courseId = cg.courseId\n"
                + "JOIN coursecategory cc ON cc.courseCategoryId = c.courseCategoryId\n"
                + "JOIN duration d ON d.durationId = c.durationId \n"
                + "WHERE 1=1 AND cg.createdTime >= ? AND cg.createdTime <= ?";
        if (email != null) {
            sql += " AND a.email LIKE ?";
        }
        if (courseName != null) {
            sql += " AND c.name LIKE ?";
        }
        if (category != 0) {
            sql += " AND c.courseCategoryId = ?";
        }
        if (duration != 0) {
            sql += " AND c.durationId = ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, startTime);
            stm.setDate(2, endTime);
            int parameterIndex = 3; // Starting index for additional parameters
            if (email != null) {
                stm.setString(parameterIndex++, "%" + email + "%");
            }
            if (courseName != null) {
                stm.setString(parameterIndex++, "%" + courseName + "%");
            }
            if (category != 0) {
                stm.setInt(parameterIndex++, category);
            }
            if (duration != 0) {
                stm.setInt(parameterIndex++, duration);
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("numRegCourse");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DBContext.close(connection);
        }
        return 0;

    }

    @Override
    public List<CourseRegistration> searchCourseRegistrations(String email, String courseName, int category, int duration, Date startTime, Date endTime, int pageIndex) {
        List<CourseRegistration> searchCourseRegistrations = new ArrayList<>();
        Connection connection = DBContext.getConnection();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY cg.registerId ASC) AS rownum,cg.registerId,a.email, c.name AS coursename, \n"
                + "cc.name AS category,cc.courseCategoryId AS categoryId, d.name AS duration, d.durationId AS durationId, cg.createdTime, c.price AS cost\n"
                + "FROM account a JOIN user u ON a.accId = u.accId\n"
                + "JOIN courseregistration cg ON cg.userId = u.userId\n"
                + "JOIN course c ON c.courseId = cg.courseId\n"
                + "JOIN coursecategory cc ON cc.courseCategoryId = c.courseCategoryId\n"
                + "JOIN duration d ON d.durationId = c.durationId\n"
                + "WHERE cg.createdTime >= ? AND cg.createdTime <= ?";
        if (email != null) {
            sql += " AND a.email LIKE ?";
        }
        if (courseName != null) {
            sql += " AND c.name LIKE ?";
        }
        if (category != 0) {
            sql += " AND c.courseCategoryId = ?";
        }
        if (duration != 0) {
            sql += " AND c.durationId = ?";
        }
        sql += ") r \n"
                + "WHERE 1=1 AND rownum >= (? - 1) * 5 + 1 AND rownum <= ? * 5";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, startTime);
            stm.setDate(2, endTime);
            int parameterIndex = 3; // Starting index for additional parameters
            if (email != null) {
                stm.setString(parameterIndex++, "%" + email + "%");
            }
            if (courseName != null) {
                stm.setString(parameterIndex++, "%" + courseName + "%");
            }
            if (category != 0) {
                stm.setInt(parameterIndex++, category);
            }
            if (duration != 0) {
                stm.setInt(parameterIndex++, duration);
            }
            stm.setInt(parameterIndex++, pageIndex);
            stm.setInt(parameterIndex++, pageIndex);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CourseRegistration courseRegistration = new CourseRegistration();
                courseRegistration.setCourseRegisterationId(rs.getInt("registerId"));
                Account acc = new Account();
                acc.setEmail(rs.getString("email"));
                User user = new User();
                user.setAccount(acc);
                courseRegistration.setUser(user);
                Course course = new Course();
                course.setName(rs.getString("coursename"));
                CourseCategory courseCategory = new CourseCategory();
                courseCategory.setName(rs.getString("category"));
                course.setCategory(courseCategory);
                Duration dur = new Duration();
                dur.setName(rs.getString("duration"));
                course.setDuration(dur);
                course.setPrice(rs.getInt("cost"));
                courseRegistration.setCourse(course);
                courseRegistration.setCreatedTime(rs.getDate("createdTime"));
                searchCourseRegistrations.add(courseRegistration);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return searchCourseRegistrations;
    }

    @Override
    public int countRegisterCourseByDay(String date) {
        Connection connection = DBContext.getConnection();
        int count = 0;
        String sql = "SELECT COUNT(*) AS total FROM courseregistration WHERE createdTime = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, date);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("total");
                return count;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return count;
    }

    @Override
    public int totalIncomeByDay(String date) {
        Connection connection = DBContext.getConnection();
        int total = 0;
        String sql = "SELECT SUM(c.price) AS totalincome\n"
                + "FROM account a JOIN user u ON a.accId = u.accId\n"
                + "JOIN courseregistration cg ON cg.userId = u.userId\n"
                + "JOIN course c ON c.courseId = cg.courseId\n"
                + "JOIN coursecategory cc ON cc.courseCategoryId = c.courseCategoryId\n"
                + "JOIN duration d ON d.durationId = c.durationId\n"
                + "WHERE cg.createdTime = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, date);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                total = rs.getInt("totalincome");
                return total;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return total;
    }

    @Override
    public boolean addNewEnrollments(int userId, String[] courses) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`courseregistration` "
                + "(`userId`, `courseId`, `createdTime`) "
                + "SELECT ?, ?, NOW() "
                + "FROM DUAL "
                + "WHERE NOT EXISTS (SELECT 1 FROM `swp391_onlinelearning`.`courseregistration` "
                + "WHERE `userId` = ? AND `courseId` = ?)";

        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            for (int i = 0; i < courses.length; i++) {
                int courseId = Integer.parseInt(courses[i]);
                stm.setInt(1, userId);
                stm.setInt(2, courseId);
                stm.setInt(3, userId);
                stm.setInt(4, courseId);
                stm.addBatch();
            }
            stm.executeBatch();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            DBContext.close(connection);
        }
    }

    @Override
    public long getTotalIncome(String email, String courseName, int category, int duration, Date startTime, Date endTime) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT SUM(c.price) AS totalIncome\n"
                + "FROM account a JOIN user u ON a.accId = u.accId\n"
                + "JOIN courseregistration cg ON cg.userId = u.userId\n"
                + "JOIN course c ON c.courseId = cg.courseId\n"
                + "JOIN coursecategory cc ON cc.courseCategoryId = c.courseCategoryId\n"
                + "JOIN duration d ON d.durationId = c.durationId\n"
                + "WHERE 1=1 AND cg.createdTime >= ? AND cg.createdTime <= ?";
        if (email != null) {
            sql += " AND a.email LIKE ?";
        }
        if (courseName != null) {
            sql += " AND c.name LIKE ?";
        }
        if (category != 0) {
            sql += " AND c.courseCategoryId = ?";
        }
        if (duration != 0) {
            sql += " AND c.durationId = ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, startTime);
            stm.setDate(2, endTime);
            int parameterIndex = 3; // Starting index for additional parameters
            if (email != null) {
                stm.setString(parameterIndex++, "%" + email + "%");
            }
            if (courseName != null) {
                stm.setString(parameterIndex++, "%" + courseName + "%");
            }
            if (category != 0) {
                stm.setInt(parameterIndex++, category);
            }
            if (duration != 0) {
                stm.setInt(parameterIndex++, duration);
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getLong("totalIncome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseRegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            DBContext.close(connection);
        }
        return 0;
    }
}