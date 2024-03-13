/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Question;
import com.fpt.swp391_onlinelearning.model.TempQuiz;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface ITempQuizDAO {
    public void insertRandomTempQuestion(TempQuiz quiz, int numberOfQuestion);
    public void insertTempQuiz(TempQuiz quiz);
    public TempQuiz getLastUserTempQuiz(int userId, int lessonId);
    public void updateResult(TempQuiz t);
    public List<TempQuiz> getTempQuizsByUserLesson(int userId, int lessonid);
    public TempQuiz getTempQuizById(int tempId);
}
