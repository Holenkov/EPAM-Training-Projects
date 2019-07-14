package by.training.edocuments.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.training.edocuments.bean.Employee;

 
public class CookieUtil {
 
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
 
    public static void storeLoginedUser(HttpSession session, Employee loginedUser) {
        session.setAttribute("loginedUser", loginedUser);
    }

    public static Employee getLoginedUser(HttpSession session) {
        Employee loginedUser = (Employee) session.getAttribute("loginedUser");
        return loginedUser;
    }
 
    public static void storeUserCookie(HttpServletResponse response, Employee user) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getEmail());
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
        
    }
 
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
 
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
 
}
