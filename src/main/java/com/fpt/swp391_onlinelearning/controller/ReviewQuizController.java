/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredEnrollmentController;
import com.fpt.swp391_onlinelearning.dal.AnswerDAO;
import com.fpt.swp391_onlinelearning.dal.QuestionDAO;
import com.fpt.swp391_onlinelearning.dal.TempQuizDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.AnswerDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.QuestionDTO;
import com.fpt.swp391_onlinelearning.dto.TempQuizDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.AnswerService;
import com.fpt.swp391_onlinelearning.service.QuestionService;
import com.fpt.swp391_onlinelearning.service.TempQuizService;
import com.fpt.swp391_onlinelearning.service.iservice.IAnswerService;
import com.fpt.swp391_onlinelearning.service.iservice.IQuestionService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.ITempQuizService;
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
public class ReviewQuizController extends BaseRequiredEnrollmentController {

    private IService<QuestionDTO> _iGenQuestionSerivce;
    private IAnswerService _iAnswerService;
    private IQuestionService _iQuestionService;
    private ITempQuizService _iTempQuizService;
    
    @Override
    public void init()
    {
        _iGenQuestionSerivce= QuestionService.getInstance(new QuestionDAO(), new QuestionDAO());
        _iAnswerService= AnswerService.getInstance(new AnswerDAO(), new QuestionDAO(), new QuestionDAO());
        _iQuestionService= QuestionService.getInstance(new QuestionDAO(), new QuestionDAO());
        _iTempQuizService= TempQuizService.getInstance(new TempQuizDAO());
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        int lessonId= Integer.parseInt(req.getParameter("lessonId"));
        int tempId= Integer.parseInt(req.getParameter("tempId"));
        
        String s_questionId= req.getParameter("questionId");
        UserDTO udto = (UserDTO) req.getSession().getAttribute("user");
        List<QuestionDTO> attemptQuestionList= _iQuestionService.getCurrentAttemptQuestions(udto.getUserId(), lessonId);
        String firstQuestionId= String.valueOf(attemptQuestionList.get(0).getQuestionId());
        s_questionId= (s_questionId==null||s_questionId.length()==0)?firstQuestionId:s_questionId;
        
        int questionId= Integer.parseInt(s_questionId);
        QuestionDTO qdto= _iGenQuestionSerivce.get(questionId);
        List<AnswerDTO> answerList= _iAnswerService.getAnswerByQuestion(questionId);
        int questionIndex= _iQuestionService.getIndexOfQuestion(qdto, attemptQuestionList);
        List<AnswerDTO> answerInTempQuestion= _iAnswerService.getAnswerInTemp(tempId, questionId);
        List<AnswerDTO> trueAnswerList= _iAnswerService.getTrueAnswerInQuestion(questionId);
        TempQuizDTO currentTempQuiz= _iTempQuizService.getLastUserTempQuiz(udto.getUserId(), lessonId);
        int trueAnswersInTemp= _iAnswerService.trueAnswerInTemp(tempId, attemptQuestionList);
        int numberOfTrueAnswer= _iAnswerService.numberOfTrueAnswer(questionId);
        
        req.setAttribute("trueAnswers", trueAnswersInTemp);
        req.setAttribute("questionSize", attemptQuestionList.size());
        req.setAttribute("courseId", courseId);
        req.setAttribute("questionId", questionId);
        req.setAttribute("tempId", tempId);
        req.setAttribute("index", questionIndex);
        req.setAttribute("question", qdto);
        req.setAttribute("answerList", answerList);
        req.setAttribute("questionList", attemptQuestionList);
        req.setAttribute("answersQuestion", answerInTempQuestion);
        req.setAttribute("trueAnswerList", trueAnswerList);
        req.setAttribute("tempQuiz", currentTempQuiz);
        req.setAttribute("numOfAnswer", numberOfTrueAnswer);
        req.getRequestDispatcher("view/quizreview.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean canJoin) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
