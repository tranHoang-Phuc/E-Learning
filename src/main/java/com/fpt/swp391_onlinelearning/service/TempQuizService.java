/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.ITempQuizDAO;
import com.fpt.swp391_onlinelearning.dto.TempQuizDTO;
import com.fpt.swp391_onlinelearning.model.TempQuiz;
import com.fpt.swp391_onlinelearning.service.iservice.ITempQuizService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phuc2
 */
public class TempQuizService implements ITempQuizService{
    private static TempQuizService tempQuizService;
    private ITempQuizDAO _iTempQuizDAO;
    
    public static TempQuizService getInstance(ITempQuizDAO iTempQuizDAO)
    {
        if(tempQuizService==null)
        {
            tempQuizService= new TempQuizService(iTempQuizDAO);
        }
        return tempQuizService;
    }
    public TempQuizService(ITempQuizDAO iTempQuizDAO)
    {
        this._iTempQuizDAO=iTempQuizDAO;
    }

    @Override
    public void insertRandomTempQuestion(TempQuizDTO quiz, int numberOfQuestion) {
        TempQuiz t= Converter.toDomain(quiz);
        _iTempQuizDAO.insertRandomTempQuestion(t, numberOfQuestion);    
    }

    @Override
    public void insertTempQuiz(TempQuizDTO quiz) {
        TempQuiz t= Converter.toDomain(quiz);
        _iTempQuizDAO.insertTempQuiz(t);
        
        
    }
    

    @Override
    public TempQuizDTO getLastUserTempQuiz(int userId, int lessonId) {
        return Converter.toDTO(_iTempQuizDAO.getLastUserTempQuiz(userId, lessonId));
    }

    @Override
    public void updateResult(TempQuizDTO tqdto) {
        TempQuiz t= Converter.toDomain3(tqdto);
        
        _iTempQuizDAO.updateResult(t);
    }

    @Override
    public List<TempQuizDTO> getTempByUserLesson(int userId, int lessonId) {
        List<TempQuizDTO> tempQuizDTOs= new ArrayList<>();
        List<TempQuiz> tempList= _iTempQuizDAO.getTempQuizsByUserLesson(userId, lessonId);
        
        for(TempQuiz t: tempList)
        {
            TempQuizDTO tqdto= new TempQuizDTO();
            tqdto= Converter.toDTO(t);
            tempQuizDTOs.add(tqdto);
        }
        return tempQuizDTOs;
    }

    @Override
    public TempQuizDTO getTempQuizById(int tempId) {
        return Converter.toDTO(_iTempQuizDAO.getTempQuizById(tempId));
    }
    
    
}
