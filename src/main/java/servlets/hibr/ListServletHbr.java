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

 // name = "ShowAllUsersHbr", description = "Вывод всех пользователей - списком...", urlPatterns =

@WebServlet("/user/list")
public class ListServletHbr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reqv, HttpServletResponse resp) throws ServletException, IOException {

        UserHibrService uhs = UserHibrService.getInstance();
        List<User> usrsLst = uhs.getAllUsers();
        reqv.setAttribute("usrsLst", usrsLst);
        RequestDispatcher requestDispatcher = reqv.getRequestDispatcher("/listhbr.jsp");
        requestDispatcher.forward(reqv, resp);

    }

    @Override
    protected void doPost(HttpServletRequest reqv, HttpServletResponse resp) throws ServletException, IOException {

        UserHibrService uhs = UserHibrService.getInstance();
        List<User> usrsLst = uhs.getAllUsers();
        reqv.setAttribute("usrsLst", usrsLst);
        RequestDispatcher requestDispatcher = reqv.getRequestDispatcher("/listhbr.jsp");
        requestDispatcher.forward(reqv, resp);

    }

}
