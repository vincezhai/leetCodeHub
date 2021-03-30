package leetcode.test.reflectTest;

public class Test {
    public static void main(String[] args) {
        Entity entity = new Entity();
        System.out.println("entity.toString() = " + entity.toString());
        CommonUtils.formatEntity(entity);
        System.out.println("entity.toString() = " + entity.toString());

        System.out.println();

        EntityCopy entityCopy = new EntityCopy();
        System.out.println("entityCopy.toString() = " + entityCopy.toString());
        CommonUtils.formatEntity(entityCopy);
        System.out.println("entityCopy.toString() = " + entityCopy.toString());
    }
}
