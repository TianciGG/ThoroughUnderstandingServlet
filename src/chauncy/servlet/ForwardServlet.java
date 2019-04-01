package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @classDesc: 功能描述(转发请求servlet)  
 * @author: ChauncyWang
 * @createTime: 2019年3月30日 下午2:35:17   
 * @version: 1.0  
 */ 
@WebServlet("/ForwardServlet")
public class ForwardServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("userName", "ChauncWang");
		//跳转有两种方式，一种是转发一种是重定向，此处使用转发。
		req.getRequestDispatcher("/GetDataServlet").forward(req, resp);
	}
}
