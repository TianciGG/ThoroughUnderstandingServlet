package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 多个请求同时访问servlet 会被实例化多少次？ 1次   证明:通过反射创建对象会访问构造函数，只要证明构造函数执行一次
 * init() 初始化，只会执行一次
 * service() 请求发送，doGet、doPost、doPut、doDelete
 * destory() 销毁方法，只会执行一次
 *   
 * @classDesc: 功能描述(servlet生命周期)  
 * @author: ChauncyWang
 * @createTime: 2019年3月27日 下午8:39:48   
 * @version: 1.0  
 */  
public class ServletLifecycle extends HttpServlet{
	public ServletLifecycle(){
		System.out.println("ServletLifecycle 构造函数被执行。。。");
	}
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	/**
	 * doGet是被service执行的。。。。
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
