package rest;

import entity.User;
import org.flywaydb.core.Flyway;
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
        Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://ec2-52-30-81-192.eu-west-1.compute.amazonaws.com:5432/d7us9cuv0gfcfh", "ykdnhbaritwmgn", "9f9e57371797d72553144bb143670029842475cb1dca453aefbf1e2f28761f34").load();
        flyway.repair();
        flyway.clean();
        flyway.migrate();
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
