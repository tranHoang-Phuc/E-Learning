/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ICourseDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.util.DatetimeUtil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class CourseService implements IService<CourseDTO>, ICourseService {

    private IDAO<Course> _iDao;
    private ICourseDAO _iCourseDAO;
    private static CourseService courseService;

    public CourseService(IDAO<Course> _iDao, ICourseDAO _iCourseDAO) {
        this._iDao = _iDao;
        this._iCourseDAO = _iCourseDAO;
    }

    public static CourseService getInstance(IDAO courseDAO, ICourseDAO _iCourseDAO) {
        if (courseService == null) {
            courseService = new CourseService(courseDAO, _iCourseDAO);
        }
        return courseService;
    }

    @Override
    public List<CourseDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CourseDTO get(int id) {
        return Converter.toDTO(_iDao.get(id));
    }

    @Override
    public boolean update(CourseDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(CourseDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CourseDTO> getRecentlyCourses(int numberOfCourse) {
        List<Course> courseList = _iCourseDAO.getRecentlyCourse(numberOfCourse);
        List<CourseDTO> courseDTOList = new ArrayList<CourseDTO>();
        for (Course c : courseList) {
            CourseDTO cdto = Converter.toDTO(c);
            courseDTOList.add(cdto);
        }
        return courseDTOList;
    }

    @Override
    public int getCount(int ccid, String name, int levelid, int durationid, int languageid) {
        return _iCourseDAO.getCount(ccid, name, levelid, durationid, languageid);
    }

    @Override
    public List<CourseDTO> getAllCourse(int pageindex, int pagesize, int sort, int ccid, String name, int levelid, int durationid, int languageid) {
        List<Course> course = _iCourseDAO.getAllCourse(pageindex, pagesize, sort, ccid, name, levelid, durationid, languageid);
        return Converter.toDTO(course);
    }

    @Override
    public CourseDTO getCourseDetail(int courseId) {
        Course cdto = _iCourseDAO.getCourseDetail(courseId);
        return Converter.toDTO3(cdto);
    }

    @Override
    public List<CourseDTO> getRegisteredCourseByUserId(UserDTO user, AccountDTO acc, String searchValue, String categoryId, String from, String to, String pageIndex) {
        int category = categoryId == null || categoryId.trim().length() == 0 ? 0 : Integer.parseInt(categoryId);
        int page = pageIndex == null || pageIndex.trim().length() == 0 ? 1 : Integer.parseInt(pageIndex);
        if (searchValue == null || searchValue.trim().length() == 0) {
            searchValue = "";
        }
        Date fromDate;
        Date toDate;

        if (from == null || from.trim().length() == 0) {
            fromDate = acc.getRegisteredTime();
        } else {
            fromDate = Date.valueOf(from);
        }
        if (to == null || to.trim().length() == 0) {
            toDate = DatetimeUtil.getFollowingDate(DatetimeUtil.getCurrentSqlDateString());
        } else {
            toDate = Date.valueOf(to);
        }
        List<Course> courses = _iCourseDAO.getUserRegisterdCourse(user.getUserId(), searchValue, category, fromDate, toDate, page);
        List<CourseDTO> dtos = new ArrayList<>();
        for (Course course : courses) {
            dtos.add(Converter.toDto4(course));
        }
        return dtos;
    }

    @Override
    public int getNumRegisteredCourseByUserId(UserDTO user, AccountDTO acc, String searchValue, String categoryId, String from, String to) {
        int category = categoryId == null || categoryId.trim().length() == 0 ? 0 : Integer.parseInt(categoryId);
        if (searchValue == null || searchValue.trim().length() == 0) {
            searchValue = "";
        }
        Date fromDate;
        Date toDate;

        if (from == null || from.trim().length() == 0) {
            fromDate = acc.getRegisteredTime();
        } else {
            fromDate = Date.valueOf(from);
        }
        if (to == null || to.trim().length() == 0) {
            toDate = DatetimeUtil.getFollowingDate(DatetimeUtil.getCurrentSqlDateString());
        } else {
            toDate = Date.valueOf(to);
        }
        return _iCourseDAO.getNumOfUserRegisterdCourse(user.getUserId(), searchValue, category, fromDate, toDate);
    }
}
