package org.yugzan.dymamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler  {
	
    private Object delegate;
    
    public DynamicProxy(Object target) {
    	this.delegate = target;
	}
    
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("Start method " + method.getName());
		
		Object result = null;

        try {
            if (method.getName().equals("playGame") && args != null && args.length >= 1) {
              if (args[0] instanceof String) {
                    args[0] = args[0] + " Modified by DynamicProxy";
              }
            }
        	result = method.invoke(this.delegate , args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }

		System.out.println("Finish method " + method.getName());
		
		return result;
	}
	
    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
			delegate.getClass().getClassLoader(), 
			delegate.getClass().getInterfaces(), 
            this
        );
    }

}
