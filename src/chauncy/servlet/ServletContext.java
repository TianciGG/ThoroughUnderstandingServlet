package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @classDesc: 功能描述(servlet上下文的使用)
 * @author: ChauncyWang
 * @createTime: 2019年3月29日 下午6:55:42
 * @version: 1.0
 */
@WebServlet("/ServletContext")
public class ServletContext extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		javax.servlet.ServletContext servletContext = this.getServletContext();
		// 获取当前项目上下文路径
		String contextPath = servletContext.getContextPath();
		// 跳转网页使用：转发或者重定向
		resp.sendRedirect(contextPath + "/ServletLifecycle");// 重定向
	}
}
