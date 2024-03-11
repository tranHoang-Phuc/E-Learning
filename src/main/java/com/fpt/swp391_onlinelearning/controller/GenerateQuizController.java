/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredEnrollmentController;
import com.fpt.swp391_onlinelearning.dal.TempQuizDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LessonDTO;
import com.fpt.swp391_onlinelearning.dto.TempQuizDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.model.TempQuiz;
import com.fpt.swp391_onlinelearning.service.TempQuizService;
import com.fpt.swp391_onlinelearning.service.iservice.ITempQuizService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author phuc2
 */
public class GenerateQuizController extends BaseRequiredEnrollmentController {

    private ITempQuizService _itempQuizService;
    
    @Override
    public void init()
    {
        _itempQuizService= TempQuizService.getInstance(new TempQuizDAO());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        int lessonId= Integer.parseInt(req.getParameter("lessonId"));
        TempQuizDTO tdto= new TempQuizDTO();
        UserDTO udto = (UserDTO) req.getSession().getAttribute("user");
        LessonDTO ldto= new LessonDTO();
        ldto.setLessonId(lessonId);
        tdto.setLesson(ldto);
        tdto.setUser(udto);
        if(_itempQuizService.getLastUserTempQuiz(udto.getUserId(), lessonId).getResult()<0)
        {
            resp.sendRedirect("quizlesson?courseId="+courseId+"&lessonId="+lessonId+"&tempId="+_itempQuizService.getLastUserTempQuiz(udto.getUserId(), lessonId).getTempId());
        }
        else
        {
            _itempQuizService.insertTempQuiz(tdto);
            _itempQuizService.insertRandomTempQuestion(tdto, 4);
            int tempId= _itempQuizService.getLastUserTempQuiz(udto.getUserId(), lessonId).getTempId();
            resp.sendRedirect("quizlesson?courseId="+courseId+"&lessonId="+lessonId+"&tempId="+tempId);
        }    
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
