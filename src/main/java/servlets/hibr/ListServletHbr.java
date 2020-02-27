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

@WebServlet(
        name = "ShowAllUsersHbr",
        description = "Вывод всех пользователей - списком...",
        urlPatterns = "/listhbr"
)

public class ListServletHbr extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reqv, HttpServletResponse resp) throws ServletException, IOException {

        UserHibrService uhs = new UserHibrService();
        List<User> usrsLst = uhs.getAllUsers();
        reqv.setAttribute("usrsLst", usrsLst);
        RequestDispatcher requestDispatcher = reqv.getRequestDispatcher("views/hibr/listhbr.jsp");
        requestDispatcher.forward(reqv, resp);

    }
}
