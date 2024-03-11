/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IChapterDAO {
    public void addChapterAtPosition(String chapterName, int position, int courseId);
    public String updateChapterSequence(int chapterId, int sequence, String position, boolean isFirst, int courseId);
}
