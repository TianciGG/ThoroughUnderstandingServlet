package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证servlet上下文作用域 <br/>
 * servlet上下文作用域保存在服务器端，多用户共享使用,类似于全局变量，不建议使用。
 * @classDesc: 功能描述(创建servlet上下文属性值)
 * @author: ChauncyWang
 * @createTime: 2019年3月29日 下午6:55:14
 * @version: 1.0
 */
@WebServlet("/ServletContextActionScope")
public class ServletContextActionScope extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().setAttribute("userName", "ChauncyWang");
	}
}
