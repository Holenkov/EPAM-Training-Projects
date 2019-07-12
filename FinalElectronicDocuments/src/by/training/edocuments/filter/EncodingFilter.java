package by.training.edocuments.filter;
import java.io.*;
import javax.servlet.*;

public class EncodingFilter implements Filter{


	    private static final String ENCODING_DEFAULT = "UTF-8";

	    public void destroy(){
	    }

	    public void doFilter(ServletRequest request, ServletResponse responce,
	                         FilterChain chain) throws ServletException, IOException{
	    	request.setCharacterEncoding(ENCODING_DEFAULT);
	        chain.doFilter(request, responce);
	    }
	
}
