/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ILessonDAO;
import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.dto.LessonDTO;
import com.fpt.swp391_onlinelearning.model.Chapter;
import com.fpt.swp391_onlinelearning.model.Lesson;
import com.fpt.swp391_onlinelearning.service.iservice.ILessonService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public class LessonService implements ILessonService, IService<LessonDTO> {

    private ILessonDAO _iLessonDAO;
    private IDAO<Lesson> _iDao;
    private static LessonService lessonService;

    public LessonService(ILessonDAO _iLessonDAO, IDAO<Lesson> _iDao) {
        this._iLessonDAO = _iLessonDAO;
        this._iDao = _iDao;
    }

    public static LessonService getInstance(ILessonDAO iLessonDAO, IDAO<Lesson> _iDao) {
        if (lessonService == null) {
            lessonService = new LessonService(iLessonDAO, _iDao);
        }
        return lessonService;
    }

    @Override
    public Map<ChapterDTO, List<LessonDTO>> getLessonByUser(int courseId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Map<ChapterDTO, List<LessonDTO>> getLessonByCourse(int courseId) {
        Map<Chapter, List<Lesson>> lessonsMappingChapter = _iLessonDAO.getLessonByCourse(courseId);
        Map<ChapterDTO, List<LessonDTO>> lessonMap = new LinkedHashMap<>();
        for (Map.Entry<Chapter, List<Lesson>> entry : lessonsMappingChapter.entrySet()) {
            ChapterDTO key = Converter.toDto(entry.getKey());
            List<Lesson> value = entry.getValue();
            List<LessonDTO> dtos = new ArrayList<>();
            for (Lesson lesson : value) {
                dtos.add(Converter.toDto(lesson));
            }
            lessonMap.put(key, dtos);
        }
        return lessonMap;
    }

    @Override
    public int getNumberOfLesson(Map<ChapterDTO, List<LessonDTO>> map) {
        int num = 0;
        for (Map.Entry<ChapterDTO, List<LessonDTO>> entry : map.entrySet()) {
            ChapterDTO key = entry.getKey();
            List<LessonDTO> value = entry.getValue();
            num += value.size();
        }
        return num;
    }

    @Override
    public List<LessonDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LessonDTO get(int id) {
        return Converter.toDto(_iDao.get(id));
    }

    @Override
    public boolean update(LessonDTO t) {
        return false;
    }

    @Override
    public boolean insert(LessonDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        return _iDao.delete(id);
    }

    @Override
    public int getCurrentLesson(int courseId, int userId) {
        return _iLessonDAO.getCurrentLesson(courseId, userId);
    }

    @Override
    public int getNextLesson(int userId, int current) {
        return _iLessonDAO.getNextLesson(userId, current);
    }

    @Override
    public int getFirstLessonId(int courseId) {
        return _iLessonDAO.getFirstLessonId(courseId);
    }

    @Override
    public int getLastLessonId(int courseId) {
        return _iLessonDAO.getLastLessonId(courseId);
    }

    @Override
    public int getPreviousLesson(int userId, int current, int courseId) {
        return _iLessonDAO.getPreviousLesson(userId, current, courseId);
    }

    @Override
    public void updateLessonSequece(String lessonName, int sequence, String position, int chapterId,
            int typeId, int duration, String content, int currentLesson, String index, int[] lessonId) {
        if (index != null) {
            if (index.equals("first")) {
                _iLessonDAO.addLessonAtPosition(lessonName, sequence - 1, chapterId, typeId, duration, content, lessonId);
            } else if (index.equals("last")) {
                _iLessonDAO.addLessonAtPosition(lessonName, sequence + 1, chapterId, typeId, duration, content, lessonId);
            } else {
                if (position.equals("after")) {
                    _iLessonDAO.updateChapterSequence(currentLesson, sequence, position, false, chapterId);
                    _iLessonDAO.addLessonAtPosition(lessonName, sequence + 1, chapterId, typeId, duration, content, lessonId);
                } else {
                    _iLessonDAO.updateChapterSequence(currentLesson, sequence, position, false, chapterId);
                    _iLessonDAO.addLessonAtPosition(lessonName, sequence - 1, chapterId, typeId, duration, content, lessonId);
                }
            }
        }
    }

    @Override
    public void addLessonAddFirst(String lessonName, int chapterId, int typeId, int duration, String content, int[] lessonId) {
        _iLessonDAO.addLessonAtPosition(lessonName, 1, chapterId, typeId, duration, content, lessonId);
    }

    @Override
    public void updateArticle(int lessonId, String lessonName, String content) {
        _iLessonDAO.updateArticle(lessonId, lessonName, content);
    }

}
