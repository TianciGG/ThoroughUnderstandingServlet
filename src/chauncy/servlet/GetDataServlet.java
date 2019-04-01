package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**   
 * @classDesc: 功能描述(获取参数)  
 * @author: ChauncyWang
 * @createTime: 2019年3月30日 下午2:42:29   
 * @version: 1.0  
 */  
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = (String) req.getAttribute("userName");
		System.out.println("userName:"+userName);
	}
}
