package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**  
 * 验证servlet上下文作用域 
 * @classDesc: 功能描述(调用servlet上下文属性值)  
 * @author: ChauncyWang
 * @createTime: 2019年3月29日 下午7:31:57   
 * @version: 1.0  
 */  
@WebServlet("/ServletContextActionScopeCall")
public class ServletContextActionScopeCall extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = (String) this.getServletContext().getAttribute("userName"); 
		System.out.println("userName:"+userName);
	}
}
