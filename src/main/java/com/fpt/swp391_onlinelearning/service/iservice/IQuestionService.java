/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.AnswerDTO;
import com.fpt.swp391_onlinelearning.dto.QuestionDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phuc2
 */
public interface IQuestionService {
    public List<QuestionDTO> getCurrentAttemptQuestions(int userId, int lessonId);
    public int getIndexOfQuestion(QuestionDTO qdto, List<QuestionDTO> qdtos);
        public int getRecentId();
    
    public int insertQuestionAndGetId(String content, int lessonId);
    
    public void insertAnswers(List<String> answerContents, int questionId, List<Boolean> isTrueArray);
    
    public Map<QuestionDTO, List<AnswerDTO>> getQuestionByLesson(int lessonId);
    
    public void deleteQuestion(int questionId);
}
