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
@WebServlet("/ServletThreadSecurity")
public class ServletThreadSecurity extends HttpServlet {
	private int i=1;
	
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
	
	/**
	 * 因为servlet线程不安全，所以应该尽量避免使用全局变量。
	 * 面试中如果问到哪里遇到线程安全，举例servlet默认是单例的线程不安全。HashMap和HashTable区别，HashMap是非线程安全、非synchronized可以接受null的键值，HashTable与之相反。
	 * jdk1.5提供了ConcurrentHashMap替代HashTable，ConcurrentHashMap具有更强的可扩展性。
	 * 因为HashMap是线程不安全非synchronized而HashTable是线程安全synchronized的，所以单线程下HashMap比HashTable快。
	 * HashMap可以通过语句：Map m = Collections.synchronizeMap(hashMap);进行同步
	 * StringBuilder是线程不安全的，而StringBuffer是线程安全的。
	 * 如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized关键字，所以可以保证线程是安全的，但StringBuilder的方法则没有该关键字，所以不能保证线程安全。
	 * 但是如果在单线程情况下不保证线程安全，StringBuilder比StringBuffer快。
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is doGet()");
		resp.setCharacterEncoding("utf-8");//内容编码，防止出现中文乱码
		resp.setContentType("text/html;charset=utf-8");//向浏览器输出内容
		synchronized (ServletThreadSecurity.class) {
			resp.getWriter().write("第"+i+"次");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			i++;
		}
	}
}
