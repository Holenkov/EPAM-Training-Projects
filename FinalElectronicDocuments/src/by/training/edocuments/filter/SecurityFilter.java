package by.training.edocuments.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.edocuments.bean.Employee;
import by.training.edocuments.bean.base.RoleEnum;
import by.training.edocuments.bean.base.UserRole;
import by.training.edocuments.util.CookieUtil;

//@WebFilter("/*")
public class SecurityFilter implements Filter {
	private static String PROP_FILE_NAME = "role_url_restrictions.properties";
	private Map<UserRole, List<String>> roleURLMap;
	private List<Object> roles = null;
	private static Logger LOGGER = LogManager.getRootLogger();

	public SecurityFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Employee user = CookieUtil.getLoginedUser(session);
		String path = req.getServletPath();
		UserRole role;
		if (user != null) {
			role = user.getRole();
		} else {
			RoleEnum roleEnum = RoleEnum.NO_PERMISSIONS;
			role = new UserRole(roleEnum.getId(), roleEnum);
		}
		ArrayList<String> urlsList = new ArrayList<>(roleURLMap.get(role));
		if (urlsList.contains(path)) {
			chain.doFilter(request, response);
			return;
		} else if (user == null) {
			RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/main.html");
			request.setAttribute("errorString", "Please, Log In");
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/notAuthView.html");
			return;
		}

	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		roleURLMap = new HashMap<>();
		Properties properties = new Properties();
		try {
			properties.load(SecurityFilter.class.getClassLoader().getResourceAsStream(PROP_FILE_NAME));
		} catch (Exception e) {
			LOGGER.info("Something wrong");
		}
		Enumeration<?> propNames = properties.propertyNames();
		while (propNames.hasMoreElements()) {
			String roleStr = (String) propNames.nextElement();
			String roleURLs = properties.getProperty(roleStr);
			RoleEnum roleEnum = RoleEnum.valueOf(roleStr);
			UserRole role = new UserRole(roleEnum.getId(), roleEnum);
			roleURLMap.put(role, Arrays.asList(roleURLs.split(";")));
		}

	}

	public static boolean isContains(String path, Map<UserRole, List<String>> map) {
		for (Entry<UserRole, List<String>> map_element : map.entrySet()) {
			if (map_element.getValue().contains(path)) {
				return true;
			}
		}
		return false;
	}

}
