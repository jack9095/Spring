package dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        InterfaceObject mBeRepresent = new BeRepresent();
        ProxyF proxy = new ProxyF(mBeRepresent);
        // java.lang.reflect.Proxy.newProxyInstance(....)方法获得真实对象的代理对象
        InterfaceObject mInterfaceObject = (InterfaceObject) Proxy.newProxyInstance(mBeRepresent.getClass().getClassLoader()
                , mBeRepresent.getClass().getInterfaces(), proxy);
        // 通过代理对象调用真实对象相关接口中实现的方法，这个时候就会跳转到这个代理对象所关联的InvocationHandler的invoke方法中
        mInterfaceObject.shopping();
        // 获得真实对象的代理对象所对应的class对象的名称，用字符串表示
        System.out.println(mInterfaceObject.getClass().getName());
    }

}
