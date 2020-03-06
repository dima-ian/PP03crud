package servlets.filter;


import model.User;
import service.UserHibrService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/user/*")
public class UserFilter implements Filter {

    private UserHibrService usrHbr = UserHibrService.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  }


    @Override
    public void doFilter(ServletRequest reqv, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) reqv;

        final String email = req.getParameter("email");

        System.out.println("User filter: " + usrHbr.getUserByEmail(email));

        final User user = usrHbr.getUserByEmail(email);


        if (user == null) {
            reqv.getRequestDispatcher("/errpage.jsp").forward(reqv, resp);
        }
        if (user.getRole().equalsIgnoreCase("user")) {
            reqv.getRequestDispatcher("/user").forward(reqv, resp);
        }
        if (user.getRole().equalsIgnoreCase("admin")) {
            reqv.getRequestDispatcher("/admin").forward(reqv, resp);
        }
        else {
            HttpServletRequest request = (HttpServletRequest) reqv;
            reqv.getRequestDispatcher(request.getRequestURI()).forward(reqv, resp);
        }
    }


    @Override
    public void destroy() {  }

}
