package cn.liulin.algorithm.dhdesign.observer.middle;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * cn.liulin.algorithm.dhdesign.observer.middle$
 *
 * @author ll
 * @date 2023-02-01 16:44:03
 **/
public class Event {
    // 要执行方法的对象
    private Object object;
    // 要执行的方法名称
    private String methodName;
    // 要执行方法的参数
    private Object[] params;
    // 要执行方法的参数类型
    private Class[] paramTypes;

    public Event(Object object, String methodName, Object...args) {
        this.params = args;
        this.object = object;
        convertParamsToParamsType();
        setMethodName(methodName);
    }

    private void setMethodName(String methodName) {
        if (methodName == null) {
            throw new IllegalArgumentException("method name err");
        }
        try {
            this.object.getClass().getMethod(methodName, this.paramTypes);
        } catch (NoSuchMethodException e) {
            try {
                this.object.getClass().getDeclaredMethod(methodName, this.paramTypes);
            } catch (NoSuchMethodException e1) {
                throw new RuntimeException(String.format("对象%s没有该参数类型%s的方法%s,e:%s",object.toString(), Arrays.toString(paramTypes),methodName,e));
            }
        }
        this.methodName = methodName;
    }

    private void convertParamsToParamsType() {
        if (this.params != null) {
            this.paramTypes = new Class[this.params.length];
            for (int i = 0; i < this.params.length; i++) {
                this.paramTypes[i] = this.params[i].getClass();
            }
        }
    }

    public void invoke() {
        try {
            Method method = this.object.getClass().getMethod(this.methodName, this.paramTypes);
            method.invoke(this.object, this.params);
        } catch (NoSuchMethodException e) {
            System.out.printf("对象%s没有该参数类型%s的方法%s,e:%s%n",object.toString(),Arrays.toString(paramTypes),methodName, e);
        } catch (IllegalAccessException e) {
            System.out.printf("对象%s参数类型为%s的%s方法不可访问,e:%s",object.toString(),Arrays.toString(paramTypes),methodName, e);
        } catch (InvocationTargetException e) {
            System.out.printf("对象%s参数类型为%s的%s方法执行错误,e:%s",object.toString(),Arrays.toString(paramTypes),methodName, e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event objEvent = (Event) obj;
        if (!objEvent.object.equals(this.object)) {
            return false;
        }
        if (!objEvent.methodName.equals(this.methodName)) {
            return false;
        }
        Class[] paramTypes = objEvent.paramTypes;
        Object[] params = objEvent.params;
        return parameterEquals(paramTypes, params);
    }

    private boolean parameterEquals(Class[] paramTypes, Object[] params) {
        if (this.paramTypes == null) {
            return paramTypes == null;
        }
        if (paramTypes == null || this.paramTypes.length != paramTypes.length) {
            return false;
        }
        for (int i = 0; i < this.paramTypes.length; i++) {
            if (!this.paramTypes[i].getName().equals(paramTypes[i].getName())) {
                return false;
            }
        }
        for (int i = 0; i < this.params.length; i++) {
            if (!this.params[i].equals(params[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int h = this.object.hashCode() + this.methodName.hashCode();
        if (this.params != null && this.params.length > 0) {
            for (Object param : this.params) {
                if (param != null) {
                    h += param.hashCode();
                }
            }
        }
        return h;
    }
}
