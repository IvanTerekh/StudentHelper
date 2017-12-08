package edu.iba.sh.controller.study;

import edu.iba.sh.bean.Study;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StudyList")
public class StudyListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Study> studies = getStudyList();
        request.setAttribute("studies", studies);
        request.getRequestDispatcher("/WEB-INF/jsp/studyList.jsp").forward(request, response);
    }

    private List <Study> getStudyList() throws ServletException {
        try {
            return DaoFactory.getStudyDao().getAll();
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

}