/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.TempQuizDTO;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface ITempQuizService {
    public void insertRandomTempQuestion(TempQuizDTO quiz, int numberOfQuestion);
    public void insertTempQuiz(TempQuizDTO quiz);
    public TempQuizDTO getLastUserTempQuiz(int userId, int lessonId);
    public void updateResult(TempQuizDTO tqdto);
    public List<TempQuizDTO> getTempByUserLesson(int userId, int lessonId);
}
