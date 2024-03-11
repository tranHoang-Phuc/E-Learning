/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.model.LessonType;
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
public class LessonTypeDAO implements IDAO<LessonType> {

    @Override
    public List<LessonType> getAll() {
        Connection connection = DBContext.getConnection();
        List<LessonType> lessonTypes = new ArrayList<>();
        String sql = "SELECT typeId, name FROM lessontype";
        try {
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LessonType lt = new LessonType();
                lt.setTypeId(rs.getInt("typeId"));
                lt.setName(rs.getString("name"));
                lessonTypes.add(lt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessonTypes;
    }

    @Override
    public LessonType get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(LessonType t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(LessonType t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
