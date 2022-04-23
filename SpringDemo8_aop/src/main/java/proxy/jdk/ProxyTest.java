package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        final Target target = new Target();
        final Advance advance = new Advance();
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                //目标对象类加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advance.before();
                        Object invoke = method.invoke(target, args);
                        advance.afterReturning();
                        return invoke;
                    }
                }

        );
        proxy.save();
    }
}
