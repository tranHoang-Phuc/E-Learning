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
import com.fpt.swp391_onlinelearning.dto.TempQuizDTO;
import com.fpt.swp391_onlinelearning.model.Answer;
import com.fpt.swp391_onlinelearning.model.Question;
import com.fpt.swp391_onlinelearning.model.TempQuiz;
import com.fpt.swp391_onlinelearning.service.iservice.IAnswerService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phuc2
 */
public class AnswerService implements IAnswerService{

    private static AnswerService answerService;
    private IAnswerDAO _iAnswerDAO;
    private IQuestionDAO _iQuestionDAO;
    private IDAO<Question> _iDAO;
    
    public static AnswerService getInstance(IAnswerDAO _iAnswerDAO, IQuestionDAO _iQuestionDAO,IDAO<Question> _iDAO)
    {
        if(answerService==null)
        {
            answerService= new AnswerService(_iAnswerDAO,_iQuestionDAO, _iDAO);
        }
        return answerService;
    }
    
    public AnswerService(IAnswerDAO _iAnswerDAO, IQuestionDAO _iQuestionDAO, IDAO<Question> _iDAO)
    {
        this._iAnswerDAO=_iAnswerDAO;
        this._iQuestionDAO= _iQuestionDAO;
        this._iDAO=_iDAO;
    }

    @Override
    public List<AnswerDTO> getAnswerByQuestion(int questionId) {
        List<AnswerDTO> adtos= new ArrayList<>();
        List<Answer> answers= _iAnswerDAO.getAnswerByQuestion(questionId);
        for(Answer a: answers)
        {
            AnswerDTO adto= new AnswerDTO();
            adto= Converter.toDTO(a);
            adtos.add(adto);
        }
        return adtos;
    }

    @Override
    public void doQuestion(List<AnswerDTO> adtos, TempQuizDTO tdto) {
        List<Answer> answers= new ArrayList<>();
        for(AnswerDTO adto: adtos)
        {
            Answer a = new Answer();
            a= Converter.toDomain(adto);
            answers.add(a);
        }
        
        TempQuiz t= Converter.toDomain2(tdto);
        Question q= _iQuestionDAO.getQuestionByAnswer(answers.get(0));
        
        _iAnswerDAO.deleteRemainAnswer(q, t);
        for(Answer a:answers)
        {
             _iAnswerDAO.insertQuizAnswer(a, t);
        }
       
        
    }

    @Override
    public void deleteRemainAnswer(int questionId, TempQuizDTO tdto) {
        Question q= _iDAO.get(questionId);
        TempQuiz t= Converter.toDomain2(tdto);
        _iAnswerDAO.deleteRemainAnswer(q, t);
    }

    @Override
    public void addAnswer(AnswerDTO adto, TempQuizDTO tdto) {
        Answer a = Converter.toDomain(adto);
        TempQuiz t= Converter.toDomain2(tdto);
        _iAnswerDAO.insertQuizAnswer(a, t);
        
    }

    @Override
    public List<AnswerDTO> getAnswerInTemp(int tempId, int questionId) {
        List<Answer> answers= _iAnswerDAO.getAnswerInTemp(tempId, questionId);
        List<AnswerDTO> adtos= new ArrayList<>();
        for(Answer a: answers)
        {
            AnswerDTO adto= new AnswerDTO();
            adto= Converter.toDTO(a);
            adtos.add(adto);
        }
        return adtos;
    }

    @Override
    public boolean isTrueAnswer(int tempId, int questionId) {
        List<AnswerDTO> answerDTOs= getAnswerInTemp(tempId, questionId);
        if(answerDTOs.isEmpty())
        {
            return false;
        }
        else
        {
            for(AnswerDTO adto: answerDTOs)
            {
                if(!adto.isIsTrue())
                {
                    return false;
                }
                if(numberOfTrueCheckedAnswer(tempId, questionId)<numberOfTrueAnswer(questionId))
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int numberOfTrueAnswer(int questionId) {
        List<AnswerDTO> adtos= getAnswerByQuestion(questionId);
        int count=0;
        if(adtos.isEmpty())
        {
            return 0;
        }
        else
        {
            for(AnswerDTO adto: adtos)
            {
                if(adto.isIsTrue())
                {
                    count++;
                }
                
            }
        }
        return count;
        
    }

    @Override
    public int numberOfTrueCheckedAnswer(int tempId, int questionId) {
        List<AnswerDTO> adtos= getAnswerInTemp(tempId,questionId);
        int count=0;
        if(adtos==null)
        {
            return 0;
        }
        else
        {
            for(AnswerDTO adto: adtos)
            {
                if(adto.isIsTrue())
                {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public float getTotalMark(int tempId, List<QuestionDTO> qdtos) {
        int maxMark= 10;
        float totalMark= 0;
        for(QuestionDTO qdto: qdtos)
        {
            if(isTrueAnswer(tempId, qdto.getQuestionId()))
            {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedFloatAsString = decimalFormat.format((float) maxMark/qdtos.size());
                float formattedMark = Float.parseFloat(formattedFloatAsString);
                totalMark+=formattedMark;
            }                     
        }   
        return totalMark;
    }

    @Override
    public List<AnswerDTO> getTrueAnswerInQuestion(int questionId) {
        List<AnswerDTO> answerList= getAnswerByQuestion(questionId);
        List<AnswerDTO> trueAnswerList= new ArrayList<>();
        
        for(AnswerDTO adto: answerList)
        {
            if(adto.isIsTrue())
            {
                trueAnswerList.add(adto);
            }
        }
        return trueAnswerList;
        
    }

    @Override
    public int trueAnswerInTemp(int tempId, List<QuestionDTO> qdtos) {
        int count=0;
        for(QuestionDTO qdto: qdtos)
        {
            if(isTrueAnswer(tempId, qdto.getQuestionId()))
            {
                count++;
            }
        }
        return count;
    }

    @Override
    public Map<QuestionDTO, List<AnswerDTO>> getNumOfAnswerInEachQuestion(int tempId) {
        Map<QuestionDTO, List<AnswerDTO>> numOfAnswer= new HashMap<>();
        List<Question> questions= _iQuestionDAO.getQuestionByTempId(tempId);
        for(Question q: questions)
        {
            QuestionDTO qdto= new QuestionDTO();
            qdto= Converter.toDTO(q);
            numOfAnswer.put(qdto, getAnswerInTemp(tempId, qdto.getQuestionId()));
                    
        }
        return numOfAnswer;
    }
    
    

    
}
