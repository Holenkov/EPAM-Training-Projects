package by.training.edocuments.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.service.implementation.EmployeeServiceImpl;
import by.training.edocuments.util.CookieUtil;

 
@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
 
    public CookieFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Employee userInSession = CookieUtil.getLoginedUser(session);
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        } else {
        	session.setAttribute("COOKIE_CHECKED", null);
        }
        
    
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null) {
            String userEmail = CookieUtil.getUserNameInCookie(req);
            try {
                EmployeeServiceImpl service = new EmployeeServiceImpl();
            	Employee user = new Employee(userEmail);  
            	user = (Employee) service.findByEmail(user);
            	if (user != null) {
            		  CookieUtil.storeLoginedUser(session, user);
            	}
              
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }
 
        chain.doFilter(request, response);
    }
 
}
