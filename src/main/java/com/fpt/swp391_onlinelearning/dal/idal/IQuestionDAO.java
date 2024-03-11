/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Answer;
import com.fpt.swp391_onlinelearning.model.Question;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface IQuestionDAO {
    public List<Question> getCurrentAttemptQuestion(int userId, int lessonId);
    public Question getQuestionByAnswer(Answer a);
}
