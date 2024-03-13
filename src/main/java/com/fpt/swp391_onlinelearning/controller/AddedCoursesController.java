/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.CourseCategoryDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.DurationDAO;
import com.fpt.swp391_onlinelearning.dal.LanguageDAO;
import com.fpt.swp391_onlinelearning.dal.LevelDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.DurationDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LanguageDTO;
import com.fpt.swp391_onlinelearning.dto.LevelDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.CourseCategoryService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.DurationService;
import com.fpt.swp391_onlinelearning.service.LanguageService;
import com.fpt.swp391_onlinelearning.service.LevelService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.IDurationService;
import com.fpt.swp391_onlinelearning.service.iservice.ILanguageService;
import com.fpt.swp391_onlinelearning.service.iservice.ILevelService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class AddedCoursesController extends BaseRequiredAuthorizationController {

    private static ICourseService courseService;
    private static IService<CourseDTO> iCourseService;
    private static IService<CourseCategoryDTO> courseCategoryService;
    private static ILevelService levelService;
    private static IDurationService durationService;
    private static ILanguageService languageService;
    private static IUserService userService;

    @Override
    public void init() throws ServletException {
        courseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        courseCategoryService = CourseCategoryService.getInstance(new CourseCategoryDAO());
        levelService = LevelService.getInstance(new LevelDAO(), new LevelDAO());
        durationService = DurationService.getInstance(new DurationDAO(), new DurationDAO());
        languageService = LanguageService.getInstance(new LanguageDAO(), new LanguageDAO());
        userService = UserService.getInstace(new UserDAO(), new UserDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            List<CourseCategoryDTO> cate = courseCategoryService.getAll();
            List<LevelDTO> level = levelService.getAllLevel();
            List<DurationDTO> duration = durationService.getAllDuration();
            List<LanguageDTO> language = languageService.getAllLanguage();
            req.setAttribute("cate", cate);
            req.setAttribute("levelList", level);
            req.setAttribute("durationList", duration);
            req.setAttribute("languageList", language);
            req.getRequestDispatcher("../view/addedCoursesDashboard.jsp").forward(req, resp);
            req.setAttribute("action", action);
        } else if (action.equals("edit")) {
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            CourseDTO courseDTO = courseService.getCourseDetailAll(courseId);
            List<CourseCategoryDTO> cate = courseCategoryService.getAll();
            List<LevelDTO> level = levelService.getAllLevel();
            List<DurationDTO> duration = durationService.getAllDuration();
            List<LanguageDTO> language = languageService.getAllLanguage();
            req.setAttribute("cate", cate);
            req.setAttribute("levelList", level);
            req.setAttribute("durationList", duration);
            req.setAttribute("languageList", language);
            req.setAttribute("courseEdit", courseDTO);
            req.setAttribute("action", action);
            req.getRequestDispatcher("../view/addedCoursesDashboard.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features) throws ServletException, IOException {
        String action = req.getParameter("action");
        int courseId = -1;
        if (!req.getParameter("courseId").equals("")) {
            courseId = Integer.parseInt(req.getParameter("courseId"));
        }
        String courseName = req.getParameter("courseName");
        long price = Long.parseLong(req.getParameter("cost"));
        String levelString = req.getParameter("level");
        String durationString = req.getParameter("duration");
        String categoryString = req.getParameter("category");
        String languageString = req.getParameter("language");
        InputStream inputStream = req.getPart("imageFile").getInputStream();
        byte[] imageByte = inputStream.readAllBytes();
        String imageData;
        if (imageByte.length == 0) {
            imageData = req.getParameter("data");
        } else {
            imageData = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageByte);
        }
        String descript = req.getParameter("content");
        CourseDTO courseDTO = new CourseDTO();
        if (action.equals("edit")) {
            courseDTO.setCourseId(courseId);
        }
        courseDTO.setName(courseName);
        courseDTO.setPrice(price);
        LevelDTO levelDTO = new LevelDTO();
        levelDTO.setLevelId(Integer.parseInt(levelString));
        DurationDTO durationDTO = new DurationDTO();
        durationDTO.setDurationId(Integer.parseInt(durationString));
        CourseCategoryDTO categoryDTO = new CourseCategoryDTO();
        categoryDTO.setCourseCategoryId(Integer.parseInt(categoryString));
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setLanguageId(Integer.parseInt(languageString));
        courseDTO.setLevel(levelDTO);
        courseDTO.setDuration(durationDTO);
        courseDTO.setLanguage(languageDTO);
        courseDTO.setCategory(categoryDTO);
        courseDTO.setDescription(descript);
        courseDTO.setImg(imageData);
        UserDTO author = userService.getUserByAccountId(user.getAccId());
        courseDTO.setAuthor(author);
        if (action.equals("add")) {
            if (iCourseService.insert(courseDTO)) {
                String mesString = "Add course successfully";
                req.setAttribute("mesString", mesString);
            }
        } else if (action.equals("edit")) {
            if (iCourseService.update(courseDTO)) {
                String mesString = "Update course successfully";
                req.setAttribute("action", "edit");
                req.setAttribute("mesString", mesString);
            }
        }

        List<CourseCategoryDTO> cate = courseCategoryService.getAll();
        List<LevelDTO> level = levelService.getAllLevel();
        List<DurationDTO> duration = durationService.getAllDuration();
        List<LanguageDTO> language = languageService.getAllLanguage();
        inputStream.close();

        req.setAttribute("cate", cate);
        req.setAttribute("levelList", level);
        req.setAttribute("durationList", duration);
        req.setAttribute("languageList", language);

        req.setAttribute("name", courseName);
        req.setAttribute("price", price);
        req.setAttribute("level", levelString);
        req.setAttribute("duration", durationString);
        req.setAttribute("category", categoryString);
        req.setAttribute("language", languageString);
        req.setAttribute("content", descript);

        req.getRequestDispatcher("../view/addedCoursesDashboard.jsp").forward(req, resp);
    }

}
