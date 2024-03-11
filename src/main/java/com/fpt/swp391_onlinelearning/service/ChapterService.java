/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.dal.ChapterDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IChapterDAO;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.service.iservice.IChapterService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class ChapterService implements IChapterService, IService<ChapterDTO> {

    private IDAO<Chapter> iDao;
    private IChapterDAO iChapterDAO;
    private static ChapterService chapterSerivce;
    
    public ChapterService(IChapterDAO iChapterDAO, IDAO<Chapter> iDao) {
        this.iChapterDAO = iChapterDAO;
        this.iDao = iDao;
    }

    public static ChapterService getInstance(IChapterDAO iChapterDAO, IDAO<Chapter> iDao) {
        if (chapterSerivce == null) {
            chapterSerivce = new ChapterService(iChapterDAO, iDao);
        }
        return chapterSerivce;
    }

    @Override
    public void addChapterAtPosition(String chapterName, int position, int courseId) {
        iChapterDAO.addChapterAtPosition(chapterName, position, courseId);
    }

    @Override
    public void updateChapterSequence(int chapterId, int sequence, String position, String index, int courseId, String chapterName) {
        if (index != null) {
            if (index.equals("first")) {
                iChapterDAO.addChapterAtPosition(chapterName, sequence - 1, courseId);
            } else if (index.equals("last")) {
                iChapterDAO.addChapterAtPosition(chapterName, sequence + 1, courseId);
            } else {
                if (position.equals("after")) {
                    iChapterDAO.updateChapterSequence(chapterId, sequence, position, false, courseId);
                    iChapterDAO.addChapterAtPosition(chapterName, sequence + 1, courseId);
                } else {
                    iChapterDAO.updateChapterSequence(chapterId, sequence, position, false, courseId);
                    iChapterDAO.addChapterAtPosition(chapterName, sequence, courseId);
                }
            }
        }
    }

    @Override
    public List<ChapterDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChapterDTO get(int id) {
        Chapter c = iDao.get(id);
        ChapterDTO dto = new ChapterDTO();
        dto.setChapterId(c.getChapterId());
        dto.setName(c.getName());
        return dto;
    }

    @Override
    public boolean update(ChapterDTO t) {
        Chapter c = new Chapter();
        c.setChapterId(t.getChapterId());
        c.setName(t.getName());
        return iDao.update(c);
    }

    @Override
    public boolean insert(ChapterDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void deleteChapterId(int chapterId, int courseId) {
        iDao.delete(chapterId);
    }
    
    public static void main(String[] args) {
        new ChapterService(new ChapterDAO(), new ChapterDAO()).deleteChapterId(9, 10);
    }

    
}
