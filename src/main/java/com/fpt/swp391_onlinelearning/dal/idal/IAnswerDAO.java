/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Answer;
import com.fpt.swp391_onlinelearning.model.Question;
import com.fpt.swp391_onlinelearning.model.TempQuiz;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface IAnswerDAO {
    public List<Answer> getAnswerByQuestion(int questionId);
    public void insertQuizAnswer(Answer a, TempQuiz t);
    public void deleteRemainAnswer(Question q, TempQuiz t);
    public List<Answer> getAnswerInTemp(int tempId, int questionId);
}
