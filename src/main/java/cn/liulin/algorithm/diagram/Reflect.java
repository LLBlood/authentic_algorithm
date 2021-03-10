package cn.liulin.algorithm.diagram;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

/**
 * cn.liulin.algorithm.diagram$
 *
 * @author ll
 * @date 2021-03-09 17:37:44
 **/
public class Reflect {
    public static void main(String[] args) throws IllegalAccessException {
        User user1 = new User();
        user1.setAge(15);
        user1.setTime(new Date());
        User user2 = new User();
        user2.setAge(11);
        user2.setName("wangwu");
        String s1 = JSON.toJSONString(user1);
        String s2 = JSON.toJSONString(user2);
        JSONObject jsonObject1 = JSON.parseObject(s1);
        JSONObject jsonObject2 = JSON.parseObject(s2);
        String s = compareJsonObj(jsonObject1, jsonObject2);
        System.out.println(s);
    }

    /**
     * 比较两个相同类的jsonObj的属性值
     * @author ll
     * @date 2021-03-10 10:01:01
     * @param j1
     * @param j2
     * @return java.lang.String
     **/
    public static String compareJsonObj(JSONObject j1, JSONObject j2) throws IllegalAccessException {
        Map<String, Object[]> map = new HashMap<>();
        Set<String> keySet = j2.keySet();
        for (String key : keySet) {
            Object o1 = j1.get(key);
            Object o2 = j2.get(key);
            Object[] objArr = new Object[2];
            objArr[0] = o1;
            objArr[1] = o2;
            if (o1 == null && o2 != null) {
                map.put(key, objArr);
            } else if (o1 != null && o2 != null && !o1.equals(o2)) {
                map.put(key, objArr);
            }
        }
        return JSON.toJSONString(map);
    }

    /**
     * 比较相同类的Obj的属性值
     * @author ll
     * @date 2021-03-10 10:01:20
     * @param t1
     * @param t2
     * @return java.lang.String
     **/
    public static <T> String compareObj(T t1, T t2) throws IllegalAccessException {
        Map<String, Object[]> map = new HashMap<>();
        if (t1 == null || t2 == null) {
            return null;
        }
        Class<?> tempClazz = t1.getClass();
        Field[] declaredFields = tempClazz.getDeclaredFields();
        List<Field> list = new ArrayList<>(Arrays.asList(declaredFields));
        while ((tempClazz = tempClazz.getSuperclass()) != null) {
            Field[] tempFields = tempClazz.getDeclaredFields();
            list.addAll(Arrays.asList(tempFields));
        }

        for (Field field : list) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Type genericType = field.getGenericType();
            System.out.println(genericType);
            Object o1 = field.get(t1);
            Object o2 = field.get(t2);
            Object[] objArr = new Object[2];
            objArr[0] = o1;
            objArr[1] = o2;
            if (o1 == null && o2 != null) {
                map.put(fieldName, objArr);
            } else if (o1 != null && o2 != null && !o1.equals(o2)) {
                map.put(fieldName, objArr);
            }
        }
        return JSON.toJSONString(map);
    }
}
