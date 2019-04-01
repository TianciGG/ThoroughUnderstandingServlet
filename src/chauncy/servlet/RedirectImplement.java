package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @classDesc: 功能描述(手写实现Servlet的Redirect)  
 * @author: ChauncyWang
 * @createTime: 2019年4月1日 下午4:16:01   
 * @version: 1.0  
 */ 
@WebServlet("/RedirectImplement")
public class RedirectImplement extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(302);
		resp.setHeader("Location", this.getServletContext().getContextPath()+"/ServletLifecycle");
	}
}
