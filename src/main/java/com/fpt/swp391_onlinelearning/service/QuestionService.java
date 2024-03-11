/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;


import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IAnswerDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IQuestionDAO;
import com.fpt.swp391_onlinelearning.dto.AnswerDTO;
import com.fpt.swp391_onlinelearning.dto.QuestionDTO;
import com.fpt.swp391_onlinelearning.model.Question;
import com.fpt.swp391_onlinelearning.service.iservice.IQuestionService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author phuc2
 */
public class QuestionService implements IService<QuestionDTO>, IQuestionService{

    private static QuestionService questionSerivce;
    private IDAO<Question> _iDAO;
    private IQuestionDAO _iQuestionDAO;

    public static QuestionService getInstance(IDAO<Question> iDAO, IQuestionDAO iQuestionDAO)
    {
        if(questionSerivce==null)
        {
            questionSerivce= new QuestionService(iDAO, iQuestionDAO);
        }
        return questionSerivce;
    }
    
    public QuestionService(IDAO<Question> iDAO, IQuestionDAO iQuestionDAO)
    {
        this._iDAO=iDAO;
        this._iQuestionDAO=iQuestionDAO;

    }

    @Override
    public List<QuestionDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public QuestionDTO get(int id) {
        return Converter.toDTO(_iDAO.get(id));
    }

    @Override
    public boolean update(QuestionDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(QuestionDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<QuestionDTO> getCurrentAttemptQuestions(int userId, int lessonId) {
        List<Question> questionList= _iQuestionDAO.getCurrentAttemptQuestion(userId,lessonId);
        List<QuestionDTO> questionDTOList= new ArrayList<>();
        for(Question q:questionList)
        {
            QuestionDTO qdto= new QuestionDTO();
            qdto= Converter.toDTO(q);
            questionDTOList.add(qdto);
        }
        return questionDTOList;
        
    }

    @Override
    public int getIndexOfQuestion(QuestionDTO qdto, List<QuestionDTO> qdtos) {
        for(int i=0; i<qdtos.size();i++)
        {
            if(qdto.getQuestionId()==qdtos.get(i).getQuestionId())
            {
                return i+1;
            }
        }
        return -1;
    }


    

    
    
    
    
    
}
