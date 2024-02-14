/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.CourseRegistrationDTO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseRegistrationService {
    public List<CourseRegistrationDTO> getRegisterdCourse(int id);
    
    public int countNumberOfPageSearch(String email, String courseName, int category, int duration, Date startTime, Date endTime);

    public List<CourseRegistrationDTO> searchCourseRegistrations(String email, String courseName, int category, int duration, Date startTime, Date endTime, int pageIndex);

    public List<Integer> getCountRegList();
    
    public List<Integer> getTotalIncomeList();
    
    public boolean addNewEnrollments(int userId, String[] courses);
    
    public long getTotalIncome(String email, String courseName, int category, int duration, Date startTime, Date endTime);
    
}
