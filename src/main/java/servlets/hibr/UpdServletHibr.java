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
        name = "UpdUserHbr",
        description = "Редактирование данных пользователя - Updating...",
        urlPatterns = "/updhbr"
)

public class UpdServletHibr extends HttpServlet {

    private UserHibrService usrHbr;

    @Override
    protected void doGet(HttpServletRequest reqv, HttpServletResponse resp) throws ServletException, IOException {
        usrHbr = UserHibrService.getInstance();
        List<User> usrsLst = usrHbr.getAllUsers();
        reqv.setAttribute("usrsLst", usrsLst);
        RequestDispatcher requestDispatcher = reqv.getRequestDispatcher("views/hibr/edithbr.jsp");
        requestDispatcher.forward(reqv, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        byte age = (byte) Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String ssn = req.getParameter("ssn");
        String role = req.getParameter("role");
        User user = new User(name, sex, age, email, ssn, role);

        usrHbr = UserHibrService.getInstance();

        if (usrHbr.updateUserzData(user)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        req.setAttribute("user", user);
        doGet(req, resp);
    }



}
