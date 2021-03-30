package leetcode.test.reflectTest;

import java.lang.reflect.Field;

public class ReflactTest  {
    public static void main(String[] args) {
        Entity entity = new Entity();
        System.out.println("entity.toString() = " + entity.toString());
        formatEntity(entity);
        System.out.println("\n"+ "entity.toString() = " + entity.toString());
    }

    public static void formatEntity (Entity entity) {
        Class cl = entity.getClass();

        if(cl.getAnnotation(NeedConverted.class) == null) {
            return;
        }

        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {
            // 可以对private操作
            field.setAccessible(true);

            // 只对字符串操作
            if( !field.getType().equals(String.class)){
                continue;
            }
            try {
                // 确定当前字段信息(名字-内容)
                String currStr = (String) field.get(entity);
                String fieldName = field.getName();

                // 替换ALL
                if("ALL".equals(currStr)) {
                    field.set(entity,null);
                }

                // 字符串转换数组
                // 判断是否需要 split
                if( Entity.STR_TO_LIST_FIELDS.keySet().contains(fieldName)){
                    // 找到 当前字段 对应的 转化后数组 字段
                    Field listFieldName = cl.getDeclaredField(Entity.STR_TO_LIST_FIELDS.get(fieldName) );
                    listFieldName.setAccessible(true);
                    listFieldName.set(entity, currStr.split(","));
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
