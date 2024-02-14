/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import com.fpt.swp391_onlinelearning.model.CourseRegistration;
import java.util.ArrayList;
import java.util.List;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseRegistrationService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import java.sql.Date;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.util.DatetimeUtil;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseRegistrationService implements IService<CourseRegistrationDTO>, ICourseRegistrationService {

    private static CourseRegistrationService courseRegisterationService;
    private ICourseRegistrationDAO _iCourseRegisterationDAO;
    private IDAO<CourseRegistration> _iDao;

    public CourseRegistrationService(ICourseRegistrationDAO _iCourseRegisterationDAO, IDAO<CourseRegistration> _iDao) {
        this._iCourseRegisterationDAO = _iCourseRegisterationDAO;
        this._iDao = _iDao;

    }

    public static CourseRegistrationService getInstance(ICourseRegistrationDAO _iCourseRegisteration, IDAO<CourseRegistration> _iDao) {
        if (courseRegisterationService == null) {
            courseRegisterationService = new CourseRegistrationService(_iCourseRegisteration, _iDao);
        }
        return courseRegisterationService;
    }

    @Override
    public List<CourseRegistrationDTO> getRegisterdCourse(int id) {
        List<CourseRegistrationDTO> registerationDTOs = new ArrayList<>();
        for (CourseRegistration registeration : _iCourseRegisterationDAO.getRegisterdCourse(id)) {
            registerationDTOs.add(Converter.toDto(registeration));
        }
        return registerationDTOs;
    }

    @Override
    public int countNumberOfPageSearch(String email, String courseName, int category, int duration, Date startTime, Date endTime) {
        int totalRecord = _iCourseRegisterationDAO.countSearchRecord(email, courseName, category, duration, startTime, endTime);
        int totalPage = (totalRecord % 5 == 0) ? (totalRecord / 5) : ((totalRecord / 5) + 1);
        return totalPage;
    }

    @Override
    public List<CourseRegistrationDTO> searchCourseRegistrations(String email, String courseName, int category, int duration, Date startTime, Date endTime, int pageIndex) {
        List<CourseRegistrationDTO> registerationDTOs = new ArrayList<>();
        List<CourseRegistration> list = _iCourseRegisterationDAO.searchCourseRegistrations(email, courseName, category, duration, startTime, endTime, pageIndex);
        for (CourseRegistration courseRegisteration : list) {
            registerationDTOs.add(Converter.toDTO1(courseRegisteration));
        }
        return registerationDTOs;
    }

    @Override
    public List<Integer> getCountRegList() {
        List<Date> dates = DatetimeUtil.getCurrentWeekDates();
        List<Integer> countRegList = new ArrayList<>();
        for (Date date : dates) {
            countRegList.add(_iCourseRegisterationDAO.countRegisterCourseByDay(date.toString()));
        }
        return countRegList;
    }

    @Override
    public List<Integer> getTotalIncomeList() {
        List<Date> dates = DatetimeUtil.getCurrentWeekDates();
        List<Integer> totalIncomeList = new ArrayList<>();
        for (Date date : dates) {
            totalIncomeList.add(_iCourseRegisterationDAO.totalIncomeByDay(date.toString()));
        }
        return totalIncomeList;
    }

    @Override
    public boolean addNewEnrollments(int userId, String[] courses) {
        return _iCourseRegisterationDAO.addNewEnrollments(userId, courses);
    }

    @Override
    public long getTotalIncome(String email, String courseName, int category, int duration, Date startTime, Date endTime) {
        return _iCourseRegisterationDAO.getTotalIncome(email, courseName, category, duration, startTime, endTime);
    }

    @Override
    public List<CourseRegistrationDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CourseRegistrationDTO get(int id) {
        return Converter.toDTO2(_iDao.get(id));
    }

    @Override
    public boolean update(CourseRegistrationDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(CourseRegistrationDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
