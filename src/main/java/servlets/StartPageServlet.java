package servlets;

import model.User;
import service.UserHibrService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "StartPageServlet",
        description = "Start Page of MeCRUD",
        urlPatterns = "/"
)

public class StartPageServlet extends HttpServlet {

    private UserHibrService usrHbr = UserHibrService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/authpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest reqv, HttpServletResponse resp) throws ServletException, IOException {

        final HttpSession session = reqv.getSession();
        final String email = reqv.getParameter("email");
        final String ssn = reqv.getParameter("ssn");

        session.setAttribute("email", email);
        session.setAttribute("ssn", ssn);

        User user = usrHbr.getUserByEmail(email);
        //User user = usrHbr.getUserBySsn(ssn);
        System.out.println(user);

        if (user != null) {
            moveToMenu(reqv, resp, user.getRole());
        } else {
            reqv.getRequestDispatcher("/errpage.jsp").forward(reqv, resp);
        }


    }

    private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final String role) throws IOException, ServletException {

        if (role.equalsIgnoreCase("admin")) {
            res.sendRedirect("/admin/users");
        }
        else if (role.equalsIgnoreCase("user")) {
            res.sendRedirect("/user/list");
        }
        else {
            req.getRequestDispatcher("/errpage.jsp").forward(req, res);
        }
    }
}
