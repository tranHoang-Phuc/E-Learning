/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredEnrollmentController;
import com.fpt.swp391_onlinelearning.dal.AnswerDAO;
import com.fpt.swp391_onlinelearning.dal.QuestionDAO;
import com.fpt.swp391_onlinelearning.dal.TempQuizDAO;
import com.fpt.swp391_onlinelearning.dal.UserLessonDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.QuestionDTO;
import com.fpt.swp391_onlinelearning.dto.TempQuizDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.AnswerService;
import com.fpt.swp391_onlinelearning.service.QuestionService;
import com.fpt.swp391_onlinelearning.service.TempQuizService;
import com.fpt.swp391_onlinelearning.service.UserLessonService;
import com.fpt.swp391_onlinelearning.service.iservice.IAnswerService;
import com.fpt.swp391_onlinelearning.service.iservice.IQuestionService;
import com.fpt.swp391_onlinelearning.service.iservice.ITempQuizService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserLessonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author phuc2
 */
public class QuizResultController extends BaseRequiredEnrollmentController {

    private IAnswerService _iAnswerService;
    private IQuestionService _iQuestionService;
    private ITempQuizService _iTempQuizService;
    private IUserLessonService iUserLessonService;
    
    @Override
    public void init()
    {
        _iAnswerService= AnswerService.getInstance(new AnswerDAO(), new QuestionDAO(), new QuestionDAO());
        _iQuestionService= QuestionService.getInstance(new QuestionDAO(), new QuestionDAO());
        _iTempQuizService= TempQuizService.getInstance(new TempQuizDAO());
        iUserLessonService = UserLessonService.getInstance(new UserLessonDAO());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        int lessonId = Integer.parseInt(req.getParameter("lessonId"));
        int tempId = Integer.parseInt(req.getParameter("tempId"));
        
        UserDTO udto = (UserDTO) req.getSession().getAttribute("user");
        List<QuestionDTO> questionList= _iQuestionService.getCurrentAttemptQuestions(udto.getUserId(), lessonId);
        TempQuizDTO tqdto= new TempQuizDTO();
        tqdto.setResult(_iAnswerService.getTotalMark(tempId, questionList));
        
        tqdto.setTempId(tempId);
        _iTempQuizService.updateResult(tqdto);
        if(tqdto.getResult()>=8)
        {
            iUserLessonService.markAsDone(udto.getUserId(), lessonId);
        }
        resp.sendRedirect("reviewquiz?courseId="+courseId+"&lessonId="+lessonId+"&tempId="+tempId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
