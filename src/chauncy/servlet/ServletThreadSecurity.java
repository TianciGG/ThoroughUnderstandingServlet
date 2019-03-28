package chauncy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @classDesc: 功能描述:(证明servlet线程安不安全)
 * servlet加载流程：
 * 1.tomcat加载web.xml配置
 * 2.当发生请求来源时，先匹配<url-pattern>标签，然后寻找<servlet>配置
 * 3.解析<servlet>配置<servlet-class>
 * 4.通过java反射机制，调用Class.forName class.newInstance();无参构造函数创建对象 
 * 5.先执行servlet无参构造函数
 * 6.然后执行init方法
 * 7.之后访问service方法，进行判断请求类型，确定访问执行doGet、doPost等
 * 8.最后当服务器停止，执行销毁destroy方法
 * @author: ChauncyWang
 * @createTime: 2019年3月28日 下午11:37:26
 * @verssion: v1.0
 */
@WebServlet("ServletThreadSecurity")
public class ServletThreadSecurity extends HttpServlet {
	
	public ServletThreadSecurity(){
		System.out.println("ServletThreadSecurity无参构造函数被执行");
	}

	/**
	 * 当多个请求触发时，如果servlet的构造函数只执行一次，说明servlet时单例的。
	 * 
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("This is init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is doGet()");
	}
}
