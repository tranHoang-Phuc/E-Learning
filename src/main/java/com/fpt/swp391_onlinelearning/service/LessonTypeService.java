/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IDAO;
import com.fpt.swp391_onlinelearning.dto.LessonTypeDTO;
import com.fpt.swp391_onlinelearning.model.LessonType;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class LessonTypeService implements IService<LessonTypeDTO>{

    private IDAO<LessonType> iDao;
    private static LessonTypeService lessonTypeService;
    public LessonTypeService(IDAO<LessonType> iDao) {
        this.iDao = iDao;
    }
     
    public static LessonTypeService getInstance(IDAO<LessonType> iDao) {
        if (lessonTypeService == null) {
            lessonTypeService = new LessonTypeService(iDao);
        }
        return lessonTypeService;
    }
    @Override
    public List<LessonTypeDTO> getAll() {
        List<LessonType> lts = iDao.getAll();
        List<LessonTypeDTO> lessonTypeDTOs = new ArrayList<>();
        for (LessonType lessonType : lts) {
            lessonTypeDTOs.add(Converter.toDto(lessonType));
        }
        return lessonTypeDTOs;
    }

    @Override
    public LessonTypeDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(LessonTypeDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(LessonTypeDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
