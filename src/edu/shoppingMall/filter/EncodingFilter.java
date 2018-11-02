package edu.shoppingMall.filter;


/**
 * setCharacterEncoding을 하기 위한 전체에 적용 되는 Filter입니다.
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class EncodingFilter implements Filter {
    String encoding;

    public void init(FilterConfig fConfig) throws ServletException {
        //초기치 Parameter 읽어오기
        encoding = fConfig.getInitParameter("encoding");
    } 

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        
        chain.doFilter(request, response);
        
    }

	public void destroy() {

	}
}
