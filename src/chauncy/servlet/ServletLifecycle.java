package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 多个请求同时访问servlet 会被实例化多少次？ 1次   证明:通过反射创建对象会访问构造函数，只要证明构造函数执行一次
 * init() 初始化，只会执行一次
 * service() 处理请求，doGet、doPost、doPut、doDelete等 
 * destory() 销毁方法，只会执行一次，在容器停止的时候把对象从堆空间删除
 * 总结：Servlet默认是单例的且在第一次请求被执行的时候才创建，而且永远在jvm中只有一个实例。
 * 如何保证在容器启动的时候创建Servlet而不是第一次请求再创建?在web.xml中使用<load-on-startup>配置servlet的自动加载，数值越大优先级越低，设置成1当容器启动的时候就会创建并且执行init方法  
 * @classDesc: 功能描述(servlet生命周期)  
 * @author: ChauncyWang
 * @createTime: 2019年3月27日 下午8:39:48   
 * @version: 1.0  
 */
@WebServlet("/ServletLifecycle")
public class ServletLifecycle extends HttpServlet {
	public ServletLifecycle() {
		System.out.println("ServletLifecycle 构造函数被执行。。。");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("执行Servlet初始化init方法");
	}

	/**
	 * doGet是被service执行的
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet方法被执行");
	}

	@Override
	public void destroy() {
		System.out.println("执行Servlet销毁destroy方法");
	}

}
