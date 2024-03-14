/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Answer;
import com.fpt.swp391_onlinelearning.model.Question;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phuc2
 */
public interface IQuestionDAO {
    public List<Question> getCurrentAttemptQuestion(int userId, int lessonId);
    public Question getQuestionByAnswer(Answer a);
        public int getRecentId();
    
    public int insertQuestionAndGetId(String content, int lessonId);
    
    public void insertAnswers(List<String> answerContents, int questionId, List<Boolean> isTrueArray);
    
    public List<Question> getQuestionByTempId(int tempId);
    
    public Map<Question, List<Answer>> getAllQuestionByLesson(int lessonId);
    public void deleteQuestion(int questionId);
}
