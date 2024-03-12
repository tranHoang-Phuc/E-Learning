/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.baseController.BaseRequiredActivationController;
import com.fpt.swp391_onlinelearning.baseController.BaseRequiredAuthorizationController;
import com.fpt.swp391_onlinelearning.dal.ChapterDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.LessonDAO;
import com.fpt.swp391_onlinelearning.dal.LessonTypeDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.ChapterDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.FeatureDTO;
import com.fpt.swp391_onlinelearning.dto.LessonDTO;
import com.fpt.swp391_onlinelearning.dto.LessonTypeDTO;
import com.fpt.swp391_onlinelearning.service.ChapterService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.LessonService;
import com.fpt.swp391_onlinelearning.service.LessonTypeService;
import com.fpt.swp391_onlinelearning.service.iservice.IChapterService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.ILessonService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tran Hoang Phuc
 */
@MultipartConfig
public class EditLessonDashboardController extends BaseRequiredActivationController {

    private ICourseService iCourseService;
    private ILessonService iLessonService;
    private IService<LessonDTO> iService;
    private IChapterService iChapterService;
    private IService<ChapterDTO> iServiceChapter;
    private IService<LessonTypeDTO> iServiceLessonType;

    @Override
    public void init() throws ServletException {
        iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        iLessonService = LessonService.getInstance(new LessonDAO(), new LessonDAO());
        iService = LessonService.getInstance(new LessonDAO(), new LessonDAO());
        iChapterService = ChapterService.getInstance(new ChapterDAO(), new ChapterDAO());
        iServiceChapter = ChapterService.getInstance(new ChapterDAO(), new ChapterDAO());
        iServiceLessonType = LessonTypeService.getInstance(new LessonTypeDAO());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean isCourseActivated) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("addChapter")) {
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            String newChapter = req.getParameter("newChapterName");
            int sequence = Integer.parseInt(req.getParameter("sequence"));
            String position = req.getParameter("position");
            int chapterId = Integer.parseInt(req.getParameter("chapterId"));
            String indexString = req.getParameter("index");
            iChapterService.updateChapterSequence(chapterId, sequence, position, indexString, courseId, newChapter);
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?&courseId=" + courseId);
        } else if (action.equals("editChapter")) {
            int chapterId = Integer.parseInt(req.getParameter("chapterId"));
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            String newChapterName = req.getParameter("newChapterName");
            ChapterDTO dto = new ChapterDTO();
            dto.setChapterId(chapterId);
            dto.setName(newChapterName);
            iServiceChapter.update(dto);
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?courseId=" + courseId);
        } else if (action.equals("deleteChapter")) {
            int chapterId = Integer.parseInt(req.getParameter("chapterId"));
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            iChapterService.deleteChapterId(chapterId, courseId);
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?courseId=" + courseId);
        } else if (action.equals("addVideoLesson")) {
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            String lessonName = req.getParameter("newLessonName");
            String position = req.getParameter("position");
            String content = req.getParameter("content");
            int typeId = Integer.parseInt(req.getParameter("lessonType"));
            int chapterId = Integer.parseInt(req.getParameter("chapterId"));
            int duration = Integer.parseInt(req.getParameter("duration"));
            if (position.trim().length() != 0) {
                int sequence = Integer.parseInt(req.getParameter("sequence"));
                int currentLesson = Integer.parseInt(req.getParameter("lessonId"));
                String index = req.getParameter("index");
                iLessonService.updateLessonSequece(lessonName, sequence, position,
                        chapterId, typeId, duration, content, currentLesson, index);
            } else {
                iLessonService.addLessonAddFirst(lessonName, chapterId, typeId, duration, content);
            }
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?courseId=" + courseId);
        } else if (action.equals("addArticleLesson")) {
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            String lessonName = req.getParameter("newLessonName");
            String position = req.getParameter("position");
            String content = req.getParameter("content");
            int typeId = Integer.parseInt(req.getParameter("lessonType"));
            int chapterId = Integer.parseInt(req.getParameter("chapterId"));
            int duration = Integer.parseInt(req.getParameter("duration"));
            if (position.trim().length() != 0) {
                int sequence = Integer.parseInt(req.getParameter("sequence"));
                int currentLesson = Integer.parseInt(req.getParameter("lessonId"));
                String index = req.getParameter("index");
                iLessonService.updateLessonSequece(lessonName, sequence, position,
                        chapterId, typeId, duration, content, currentLesson, index);
            } else {
                iLessonService.addLessonAddFirst(lessonName, chapterId, typeId, duration, content);
            }
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?courseId=" + courseId);
        } else if (action.equals("deleteLesson")) {
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            int lessonId = Integer.parseInt(req.getParameter("lessonId"));
            iService.delete(lessonId);
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?courseId=" + courseId);
        } else if (action.equals("addFirstChapter")) {
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            String newChapter = req.getParameter("chapterName");
            if (iLessonService.getLessonByCourse(courseId).isEmpty()) {
                iChapterService.addChapterAtPosition(newChapter, 1, courseId);
            }
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?courseId=" + courseId);
        } else if (action.equals("editArticle")) {
            int lessonId = Integer.parseInt(req.getParameter("lessonId"));
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            String lessonName = req.getParameter("newLessonName");
            String content = req.getParameter("content");
            iLessonService.updateArticle(lessonId, lessonName, content);
            resp.sendRedirect(req.getContextPath() + "/dashboard/editlesson?courseId=" + courseId);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, AccountDTO user, boolean isActivated, Set<FeatureDTO> features, boolean isCourseActivated) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            if (action.equals("addChapter")) {
                req.setAttribute("action", "addChapter");
            }
            if (action.equals("editChapter")) {
                req.setAttribute("action", "editChapter");
                int chapterId = Integer.parseInt(req.getParameter("chapterId"));
                ChapterDTO chapter = iServiceChapter.get(chapterId);
                req.setAttribute("chapter", chapter);
            }
            if (action.equals("deleteChapter")) {
                req.setAttribute("action", "deleteChapter");
                int chapterId = Integer.parseInt(req.getParameter("chapterId"));
                ChapterDTO chapter = iServiceChapter.get(chapterId);
                req.setAttribute("chapter", chapter);
            }
            if (action.equals("addLesson")) {
                req.setAttribute("action", "addLesson");
                List<LessonTypeDTO> lessonTypeDTOs = iServiceLessonType.getAll();
                req.setAttribute("type", lessonTypeDTOs);
            }
            if (action.equals("addNewLesson")) {
                req.setAttribute("action", "addNewLesson");
                List<LessonTypeDTO> lessonTypeDTOs = iServiceLessonType.getAll();
                req.setAttribute("type", lessonTypeDTOs);
            }
            if (action.equals("addVideoLesson")) {
                req.getRequestDispatcher("../view/addVideoLessonDashboard.jsp").forward(req, resp);
                return;
            }

            if (action.equals("addArticleLesson")) {
                req.getRequestDispatcher("../view/addArticleLesson.jsp").forward(req, resp);
                return;
            }

            if (action.equals("deleteLesson")) {
                req.setAttribute("action", "deleteLesson");
                int lessonId = Integer.parseInt(req.getParameter("lessonId"));
                LessonDTO lesson = iService.get(lessonId);
                req.setAttribute("les", lesson);
            }

            if (action.equals("editLesson")) {
                int courseId = Integer.parseInt(req.getParameter("courseId"));
                int lessonId = Integer.parseInt(req.getParameter("lessonId"));
                LessonDTO lesson = iService.get(lessonId);
                int lessonType = Integer.parseInt(req.getParameter("lst"));
                if (lessonType == 2) {
                    req.setAttribute("courseId", courseId);
                    req.setAttribute("lesson", lesson);
                    req.getRequestDispatcher("../view/addArticleLesson.jsp").forward(req, resp);
                    return;
                }
            }
        }
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        Map<ChapterDTO, List<LessonDTO>> lessons = iLessonService.getLessonByCourse(courseId);
        LessonDTO lessonDTO = null;
        if (req.getParameter("lessonId") == null) {
            for (Map.Entry<ChapterDTO, List<LessonDTO>> entry : lessons.entrySet()) {
                ChapterDTO key = entry.getKey();
                List<LessonDTO> value = entry.getValue();
                if (!value.isEmpty()) {
                    lessonDTO = value.get(0);
                }
                break;
            }
            req.setAttribute("l", lessonDTO);
        } else {
            int lessonId = Integer.parseInt(req.getParameter("lessonId"));
            lessonDTO = iService.get(lessonId);
            req.setAttribute("l", lessonDTO);
        }
        CourseDTO cdto = iCourseService.getCourseDetail(courseId);
        req.setAttribute("lesson", lessons);
        req.setAttribute("course", cdto);
        req.getRequestDispatcher("../view/editLesson.jsp").forward(req, resp);
    }

}
