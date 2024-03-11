/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IChapterService {

    public void addChapterAtPosition(String chapterName, int position, int courseId);

    public void updateChapterSequence(int chapterId, int sequence, String position, String index, int courseId, String chapterName);

    public void deleteChapterId(int chapterId, int courseId);

}
