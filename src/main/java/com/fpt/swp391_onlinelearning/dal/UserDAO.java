/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal;

import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IUserDAO;
import com.fpt.swp391_onlinelearning.model.Account;
import com.fpt.swp391_onlinelearning.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class UserDAO extends DBContext implements IUserDAO, IDAO<User> {

    private static final String DEFAULT_IMG = "data:image/jpeg;base64,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";
//    public static void main(String[] args) {
//        User u = new User();
//        u.setBalance(100000);
//        u.setUserId(1);
//        new UserDAO().updateBalance(u);
//    }

    @Override
    public User getUserByAccountId(int accId) {
        Connection connection = DBContext.getConnection();
        String sql = "SELECT `userId`, `name`, `gender`, `dob`, `phone`, `img`, "
                + "`address`, `postCode`, `accId`, `balance` "
                + "FROM `swp391_onlinelearning`.`user`"
                + "WHERE `accId` = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));
                user.setImg(rs.getString("img"));
                user.setAddress(rs.getString("address"));
                user.setPostCode(rs.getString("postCode"));
             
                Account account = new Account();
                account.setAccId(accId);
                user.setAccount(account);
                user.setBalance(rs.getLong("balance"));
                return user;

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new UserDAO().getUserByAccountId(1).getBalance());
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(User user) {
        Connection connection = DBContext.getConnection();
        String sql = "INSERT INTO `swp391_onlinelearning`.`user` "
                + "(`name`, `gender`, `dob`, `phone`, `accId`, `img`) "
                + " VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getName());
            stm.setBoolean(2, user.isGender());
            stm.setDate(3, user.getDob());
            stm.setString(4, user.getPhone());
            stm.setInt(5, user.getAccount().getAccId());
            stm.setString(6, DEFAULT_IMG);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            DBContext.close(connection);
        }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateBalance(User u) {
        Connection connection = DBContext.getConnection();
        String sql = "UPDATE `swp391_onlinelearning`.`user` SET `balance`= ? WHERE  `userId`=?;";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, u.getBalance());
            stm.setInt(2, u.getUserId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBContext.close(connection);
        }

    }

    @Override
    public void updateUser(User model) {
        Connection connection= DBContext.getConnection();
        try {
            String sql = "UPDATE `user` AS u \n"
                    + "   SET u.name=?, u.gender=?,u.dob=?,u.phone=?,u.img=?,u.address=?,u.postCode=?\n" 
                    + "   WHERE u.accId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getName());
            stm.setBoolean(2, model.isGender());
            stm.setDate(3, model.getDob());
            stm.setString(4, model.getPhone());
            stm.setString(5, model.getImg());
            stm.setString(6, model.getAddress());
            stm.setString(7, model.getPostCode());
            stm.setInt(8, model.getAccount().getAccId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            DBContext.close(connection);
        }
    }

}
