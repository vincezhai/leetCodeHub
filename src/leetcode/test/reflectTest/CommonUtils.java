package leetcode.test.reflectTest;

import java.lang.reflect.Field;
import java.util.HashMap;

public class CommonUtils {
    public static void formatEntity (Object obj) {
        // class 对象
        Class cl = obj.getClass();

        // 类注解对象
        NeedConverted annotation = (NeedConverted)cl.getAnnotation(NeedConverted.class);
        if(annotation == null) {
            return;
        }

        // 根据注解，生成转换映射表
        HashMap<String, String> strToListFieldsMap = getAnnotationMember(annotation);

        try {
            // 处理类成员
            Field[] fields = cl.getDeclaredFields();

            for (Field field : fields) {
                // 可以对private操作
                field.setAccessible(true);

                // 只对字符串操作
                if( !field.getType().equals(String.class)){
                    continue;
                }

                // 确定当前字段信息(名字-内容)
                String currStr = (String) field.get(obj);
                String fieldName = field.getName();

                // 替换ALL
                if("ALL".equals(currStr)) {
                    field.set(obj,null);
                }

                // 字符串转换数组
                // 判断是否需要 split
                if( strToListFieldsMap.keySet().contains(fieldName)){
                    // 找到 当前字段 对应的 转化后数组 字段
                    Field listFieldName = cl.getDeclaredField(strToListFieldsMap.get(fieldName) );
                    listFieldName.setAccessible(true);
                    listFieldName.set(obj, currStr.split(","));
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, String> getAnnotationMember(NeedConverted annotation ) {
        HashMap<String, String> relateMap = new HashMap<>();
        String[] strField = annotation.strField();
        String[] listField = annotation.listField();

        if(strField.length != listField.length){
            return relateMap;
        }
        for (int i = 0; i < strField.length; i++) {
            relateMap.put(strField[i], listField[i]);
        }
        return relateMap;
    }
}
