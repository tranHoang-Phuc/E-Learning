/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.baseController;

import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
public abstract class BaseRequiredActivationController extends BaseRequiredAuthorizationController {

    private ICourseService _iCourseService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        boolean activated = isCourseActivated(courseId);
        if (!activated) {
            doGet(req, resp, user, isActivated, features, activated);
        } else {
            resp.sendRedirect(req.getContextPath() + "/dashboard/courseNotifi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        boolean activated = isCourseActivated(courseId);
        if (!activated) {
            doPost(req, resp, user, isActivated, features, activated);
        } else {
            resp.sendRedirect(req.getContextPath() + "/dashboard/courseNotifi");
        }
    }

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean isCourseActivated)throws ServletException, IOException;

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean isCourseActivated)throws ServletException, IOException;

    private boolean isCourseActivated(int courseId) {
        _iCourseService = new CourseService(new CourseDAO(), new CourseDAO());
        return _iCourseService.getCourseStatus(courseId);
    }
}
