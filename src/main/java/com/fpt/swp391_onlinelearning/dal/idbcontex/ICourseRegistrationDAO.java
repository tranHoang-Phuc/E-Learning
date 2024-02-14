/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idbcontex;

import com.fpt.swp391_onlinelearning.model.CourseRegistration;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface ICourseRegistrationDAO {
    public List<CourseRegistration> getRegisterdCourse(int id);
    
    public int countSearchRecord(String email, String courseName, int category, int duration, Date startTime, Date endTime);
    
    public List<CourseRegistration> searchCourseRegistrations(String email, String courseName, int category, int duration, Date startTime, Date endTime, int pageIndex);

    public int countRegisterCourseByDay(String date);
    
    public int totalIncomeByDay(String date);
    
    public boolean addNewEnrollments(int userId, String[] courses);
    
    public long getTotalIncome(String email, String courseName, int category, int duration, Date startTime, Date endTime);

}
