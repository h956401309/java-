package aop_source;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;





///aop中  jdk动态代理底层原理
public class JDKProxy {
    public static void main(String[] args) {

        Class[] interfaces={Userdao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        Userdao dao=(Userdao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDao));
        int result=dao.add(2,3);
        System.out.println("result:"+result);
    }



}





//创建代理
class UserDaoProxy implements InvocationHandler{
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法之前"+method.getName()+"传递到参数"+ Arrays.toString(args));
        //通过反射 method类中的invoke方法  再次调用本方法
        Object ooo=method.invoke(obj,args);
        return ooo;
    }
}
