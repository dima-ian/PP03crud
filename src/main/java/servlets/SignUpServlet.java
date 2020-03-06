package servlets;

import model.User;
import service.UserHibrService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "SignUpServlet",
        description = "Sign up USER or ADMIN to MeCRUD",
        urlPatterns = "/rgstr"
)
public class SignUpServlet extends HttpServlet {

    private UserHibrService usrHbr = UserHibrService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/regpage.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        byte age = (byte) Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String ssn = req.getParameter("ssn");
        String role = req.getParameter("role");
        User user = new User(name, sex, age, email, ssn, role);
        System.out.println(user);

        usrHbr.addUser(user);

        resp.sendRedirect("/");
    }

}
