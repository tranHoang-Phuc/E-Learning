/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseRegisterationDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.model.CourseRegistration;
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
 * @author tran Hoang Phuc
 */
public class CourseRegisterationDAO implements IDAO<CourseRegistration>, ICourseRegisterationDAO {

    @Override
    public List<CourseRegistration> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CourseRegistration get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            Logger.getLogger(CourseRegisterationDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CourseRegisterationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseRegisterations;
    }

    public static void main(String[] args) {
        System.out.println(new CourseRegisterationDAO().getRegisterdCourse(1).size());
    }
}
