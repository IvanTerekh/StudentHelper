package edu.iba.sh.controller.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DaoException;
import edu.iba.sh.dao.DaoFactory;

@WebServlet("/StudentForm")
public class StudentFormController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        Student student;
        if (idStr == null) {
            student = new Student();
            student.setId(-1);
        } else {
            int id = Integer.parseInt(idStr);
            student = getStudent(id);
        }

        request.setAttribute("student", student);
        request.getRequestDispatcher("/WEB-INF/jsp/studentForm.jsp").forward(request, response);
    }

    private Student getStudent(int id) throws ServletException {
        try {
            return DaoFactory.getStudentDao().getById(id);
        } catch (DaoException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
