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
import com.fpt.swp391_onlinelearning.util.DateUtils;
import com.fpt.swp391_onlinelearning.util.DatetimeUtil;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseRegistrationService implements IService<CourseRegistrationDTO>, ICourseRegistrationService {

    private static CourseRegistrationService courseRegisterationService;
    private ICourseRegistrationDAO _iCourseRegistrationDAO;
    private IDAO<CourseRegistration> _iDao;

    public CourseRegistrationService(ICourseRegistrationDAO _iCourseRegistrationDAO, IDAO<CourseRegistration> _iDao) {
        this._iCourseRegistrationDAO = _iCourseRegistrationDAO;
        this._iDao = _iDao;

    }

    public static CourseRegistrationService getInstance(ICourseRegistrationDAO _iCourseRegistration, IDAO<CourseRegistration> _iDao) {
        if (courseRegisterationService == null) {
            courseRegisterationService = new CourseRegistrationService(_iCourseRegistration, _iDao);
        }
        return courseRegisterationService;
    }

    @Override
    public List<CourseRegistrationDTO> getRegisterdCourse(int id) {
        List<CourseRegistrationDTO> registerationDTOs = new ArrayList<>();
        for (CourseRegistration registeration : _iCourseRegistrationDAO.getRegisterdCourse(id)) {
            registerationDTOs.add(Converter.toDto(registeration));
        }
        return registerationDTOs;
    }

    @Override
    public int countNumberOfPageSearch(String email, String courseName, int category, int duration, Date startTime, Date endTime) {
        int totalRecord = _iCourseRegistrationDAO.countSearchRecord(email, courseName, category, duration, startTime, endTime);
        int totalPage = (totalRecord % 5 == 0) ? (totalRecord / 5) : ((totalRecord / 5) + 1);
        return totalPage;
    }

    @Override
    public List<CourseRegistrationDTO> searchCourseRegistrations(String email, String courseName, int category, int duration, Date startTime, Date endTime, int pageIndex) {
        List<CourseRegistrationDTO> registerationDTOs = new ArrayList<>();
        List<CourseRegistration> list = _iCourseRegistrationDAO.searchCourseRegistrations(email, courseName, category, duration, startTime, endTime, pageIndex);
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
            countRegList.add(_iCourseRegistrationDAO.countRegisterCourseByDay(date.toString()));
        }
        return countRegList;
    }

    @Override
    public List<Integer> getTotalIncomeList() {
        List<Date> dates = DatetimeUtil.getCurrentWeekDates();
        List<Integer> totalIncomeList = new ArrayList<>();
        for (Date date : dates) {
            totalIncomeList.add(_iCourseRegistrationDAO.totalIncomeByDay(date.toString()));
        }
        return totalIncomeList;
    }

    @Override
    public boolean addNewEnrollments(int userId, String[] courses) {
        return _iCourseRegistrationDAO.addNewEnrollments(userId, courses);
    }

    @Override
    public long getTotalIncome(String email, String courseName, int category, int duration, Date startTime, Date endTime) {
        return _iCourseRegistrationDAO.getTotalIncome(email, courseName, category, duration, startTime, endTime);
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

    @Override
    public List<CourseRegistrationDTO> getCourseRegistrationDTO(int pageIndex, int pageSize, Date from, Date to) {
        List<CourseRegistrationDTO> courseRegisterationDTOs= new ArrayList<>();
        for(CourseRegistration cr: _iCourseRegistrationDAO.getCourseRegistration(pageIndex, pageSize, from, to))
        {
            CourseRegistrationDTO crdto= new CourseRegistrationDTO();
            crdto= Converter.toDto2(cr);
            courseRegisterationDTOs.add(crdto);
        }
        return courseRegisterationDTOs;
    }

    @Override
    public int getCourseRegistrationAmount(Date from, Date to) {
        return _iCourseRegistrationDAO.getCourseRegistrationAmount(from, to);
    }

    @Override
    public int getTotalRegistrationRevenus(Date from, Date to) {
        return _iCourseRegistrationDAO.getTotalRegistrationRevenus(from, to);
    }

    @Override
    public List<Integer> getCourseRegistrationAmount() {
        List<Integer> courseRegistrationInCurrentWeek= new ArrayList<>();
        List<Date> datesOfCurrentWeek= DateUtils.getDatesOfCurrentWeek();
        
        for(Date date: datesOfCurrentWeek)
        {
            courseRegistrationInCurrentWeek.add(_iCourseRegistrationDAO.getCourseRegistrationAmount(date));
        }
        
        return courseRegistrationInCurrentWeek;
    }

    @Override
    public List<Integer> getMonthlyRevenueList() {
        List<Integer> monthInAYear= new ArrayList<>();
        for(int i=1; i<=12;i++)
        {
            monthInAYear.add(i);
        }
        List<Integer> monthlyRevenue= new ArrayList<>();
        for(int i: monthInAYear)
        {
            monthlyRevenue.add(_iCourseRegistrationDAO.getMonthRevenue(i));
        }
        
        return monthlyRevenue;
    }
    
    @Override
    public int getMonthRevenue(int month) {
        return _iCourseRegistrationDAO.getMonthRevenue(month);
    }

    @Override
    public Map<CourseRegistrationDTO, Integer> getCoursesTrend(int daysago) {
        Map<CourseRegistrationDTO, Integer> coursesDTOTrend = new HashMap<>();
        Map<CourseRegistration, Integer> courseTrend= _iCourseRegistrationDAO.getCoursesTrend(daysago);
        for (Map.Entry<CourseRegistration, Integer> entry : courseTrend.entrySet())
        {
            coursesDTOTrend.put(Converter.toTrendCourseDTO(entry.getKey()), entry.getValue());
        }
        return coursesDTOTrend;
    }

    @Override
    public int getNumberOfRemainningCourse(Map<CourseRegistrationDTO, Integer> courseTrend, int daysago) {
        int totalCourseRegister= _iCourseRegistrationDAO.getCourseRegistrationAmount(DateUtils.getDaysAgo(daysago),DateUtils.getCurentDate());
        int totalCourseTrend=0;
        for (Map.Entry<CourseRegistrationDTO, Integer> entry : courseTrend.entrySet())
        {
            totalCourseTrend+= entry.getValue();
        }
        return totalCourseRegister-totalCourseTrend;
    }

    @Override
    public List<CourseRegistrationDTO> getCourseRegistrationDTO(Date from, Date to) {
        List<CourseRegistrationDTO> courseRegisterationDTOs= new ArrayList<>();
        for(CourseRegistration cr: _iCourseRegistrationDAO.getCourseRegistration(from, to))
        {
            CourseRegistrationDTO crdto= new CourseRegistrationDTO();
            crdto= Converter.toDto2(cr);
            courseRegisterationDTOs.add(crdto);
        }
        return courseRegisterationDTOs;
    }

}
