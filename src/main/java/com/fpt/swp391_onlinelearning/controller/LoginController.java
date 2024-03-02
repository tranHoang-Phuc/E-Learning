/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.controller;

import com.fpt.swp391_onlinelearning.dal.AccountDAO;
import com.fpt.swp391_onlinelearning.dal.CourseDAO;
import com.fpt.swp391_onlinelearning.dal.CourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.TempEnrollmentDAO;
import com.fpt.swp391_onlinelearning.dal.UserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.service.AccountService;
import com.fpt.swp391_onlinelearning.service.CourseService;
import com.fpt.swp391_onlinelearning.service.TempEnrollmentService;
import com.fpt.swp391_onlinelearning.service.UserService;
import com.fpt.swp391_onlinelearning.service.iservice.IAccountService;
import com.fpt.swp391_onlinelearning.service.iservice.ICourseService;
import com.fpt.swp391_onlinelearning.service.iservice.IService;
import com.fpt.swp391_onlinelearning.service.iservice.ITempEnrollService;
import com.fpt.swp391_onlinelearning.service.iservice.IUserService;
import com.fpt.swp391_onlinelearning.util.CookieUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    private IAccountService _iAccountService;
    private IService _iService;
    private IUserService _iUserService;
    private ICourseService _iCourseService;
    private ITempEnrollService _iTempEnrollmentService;

    @Override
    public void init() throws ServletException {
        _iAccountService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iService = AccountService.getInstance(new AccountDAO(), new AccountDAO());
        _iUserService = UserService.getInstace(new UserDAO(), new UserDAO());
        _iCourseService = CourseService.getInstance(new CourseDAO(), new CourseDAO());
        _iTempEnrollmentService = TempEnrollmentService.getInstance(new TempEnrollmentDAO(), new CourseRegistrationDAO());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountDTO a = (AccountDTO) req.getSession().getAttribute("session");
        if (a == null) {
            CookieUtils cookieUtils = CookieUtils.getCookieUtils();
            String email = cookieUtils.getCookieUtils("email", req);
            String password = cookieUtils.getCookieUtils("password", req);
            if (email != null && password != null) {
                AccountDTO account = _iAccountService.getLogin(email, password);
                if (account != null) {
                    UserDTO userdto = _iUserService.getUserByAccountId(account.getAccId());
                    _iTempEnrollmentService.deleteTimeoutEnrollment(userdto.getUserId());
                    List<CourseDTO> dtos = _iCourseService.getTempCourseEnrollmemt(userdto.getUserId());
                    HttpSession session = req.getSession();
                    session.setAttribute("session", account);
                    if (!dtos.isEmpty()) {
                        session.setAttribute("dtos", dtos);
                    } else {
                        session.setAttribute("dtos", null);
                    }
                    session.setAttribute("user", userdto);
                    resp.sendRedirect(req.getContextPath() + "/home");
                }
            } else {
                req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        AccountDTO account = _iAccountService.getLogin(email, password);
        if (account == null) {
            String error = "Your account is invalid. Please try again";
            req.setAttribute("error", error);
            req.setAttribute("email", email);
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);

        } else if (account.getIsActivated() == 2) {
            resp.sendRedirect("view/policyViolation.jsp");
        } else {
            UserDTO userdto = _iUserService.getUserByAccountId(account.getAccId());
            _iTempEnrollmentService.deleteTimeoutEnrollment(userdto.getUserId());
            List<CourseDTO> dtos = _iCourseService.getTempCourseEnrollmemt(userdto.getUserId());
            HttpSession session = req.getSession();
            if (!dtos.isEmpty()) {
                session.setAttribute("dtos", dtos);
            } else {
                session.setAttribute("dtos", null);
            }
            session.setAttribute("session", account);
            session.setAttribute("user", userdto);
            _iAccountService.saveToCookie(resp, email, password, remember);
            resp.sendRedirect(req.getContextPath() + "/home");
        }

    }
}
