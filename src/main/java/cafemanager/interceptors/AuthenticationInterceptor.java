package cafemanager.interceptors;

import cafemanager.model.User;
import cafemanager.model.userrole.Roles;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Sevak on 2/25/2017.
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    /**
     * checking the user role
     * and there is user in session or not
     *
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            httpServletResponse.sendRedirect("redirect:/login");
            return false;
        }
        if (user.getRole() == Roles.WAITER) {
            System.out.println(user);
            httpServletResponse.sendRedirect("redirect:/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
