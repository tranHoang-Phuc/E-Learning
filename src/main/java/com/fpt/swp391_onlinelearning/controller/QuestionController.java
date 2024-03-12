/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredActivationController;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class QuestionController extends BaseRequiredActivationController{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean isCourseActivated) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean isCourseActivated) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
