package servlets.filter;


import model.User;
import service.UserHibrService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/user/*")
public class UserFilter implements Filter {

    private UserHibrService usrHbr = UserHibrService.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  }


    @Override
    public void doFilter(ServletRequest reqv, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) reqv;
        final HttpSession session = req.getSession();
        final String email = (String) session.getAttribute("email");

        final User user = usrHbr.getUserByEmail(email);

        System.out.println("User filter: " + user);

        if (user == null) {
            reqv.getRequestDispatcher("/errpage.jsp").forward(reqv, resp);
        }
        if (user.getRole().equalsIgnoreCase("user")) {
            HttpServletRequest request = (HttpServletRequest) reqv;
            reqv.getRequestDispatcher(request.getRequestURI()).forward(reqv, resp);
        }
        else {
            HttpServletRequest request = (HttpServletRequest) reqv;
            System.out.println(request.getRequestURI());
            reqv.getRequestDispatcher(request.getRequestURI()).forward(reqv, resp);
        }
    }


    @Override
    public void destroy() {  }

}
