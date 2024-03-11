/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.AnswerDTO;
import com.fpt.swp391_onlinelearning.dto.QuestionDTO;
import com.fpt.swp391_onlinelearning.dto.TempQuizDTO;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface IAnswerService {
    public List<AnswerDTO> getAnswerByQuestion(int questionId);
    public void doQuestion(List<AnswerDTO> adtos, TempQuizDTO t);
    public void deleteRemainAnswer(int questionId, TempQuizDTO t);
    public void addAnswer(AnswerDTO adto, TempQuizDTO t);
    public List<AnswerDTO> getAnswerInTemp(int tempId,int questionId);
    public boolean isTrueAnswer(int tempId,int questionId);
    public int numberOfTrueAnswer(int questionId);
    public int numberOfTrueCheckedAnswer(int tempId, int questionId);
    public float getTotalMark(int tempId, List<QuestionDTO> qdtos);
    public List<AnswerDTO> getTrueAnswerInQuestion(int questionId);
    public int trueAnswerInTemp(int tempId, List<QuestionDTO> qdtos);
}
