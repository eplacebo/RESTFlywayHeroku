package rest;

import entity.User;
import service.NoteService;
import service.impl.NoteServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StartServlet", value = "")
public class StartServlet extends HttpServlet {

    NoteService noteService;

    @Override
    public void init() throws ServletException {
        noteService = new NoteServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = noteService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/View/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
