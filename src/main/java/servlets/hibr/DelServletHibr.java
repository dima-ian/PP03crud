package servlets.hibr;

import model.User;
import service.UserHibrService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//name = "DelUserHbr",
//        description = "Редактирование данных пользователя - Updating...",
//        urlPatterns =

@WebServlet("/admin/del")
public class DelServletHibr extends HttpServlet {

    private UserHibrService usrHbr;

    @Override
    protected void doGet(HttpServletRequest reqv, HttpServletResponse resp) throws ServletException, IOException {
        usrHbr = UserHibrService.getInstance();
        List<User> usrsLst = usrHbr.getAllUsers();
        reqv.setAttribute("usrsLst", usrsLst);
        RequestDispatcher requestDispatcher = reqv.getRequestDispatcher("/adminhbr.jsp");

        requestDispatcher.forward(reqv, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        usrHbr = UserHibrService.getInstance();
        String ssn = req.getParameter("ssn");

        if (!ssn.isEmpty()) {
            usrHbr.deleteUser(ssn);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        req.setAttribute("ssn", ssn);
        doGet(req, resp);
    }




}
