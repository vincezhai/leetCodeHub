package leetcode.test.reflectTest;

public class Test {
    public static void main(String[] args) {
        Entity entity = new Entity();
        System.out.println("entity.toString() = " + entity.toString());
        CommonUtils.formatEntity(entity);
        System.out.println("\n"+ "entity.toString() = " + entity.toString());
    }
}
