package kuang;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Entity> list = new ArrayList<Entity>(){{
            add(new Entity("china",100,"yd",50));
            add(new Entity("china",100,"ld",20));
            add(new Entity("china",100,"dx",30));

            add(new Entity("usa",50,"ss",20));
            add(new Entity("usa",50,"nhk",15));
            add(new Entity("usa",50,"cell",15));

            add(new Entity("uk",10,"ss",1));
            add(new Entity("uk",10,"sky",5));
            add(new Entity("uk",10,"digi",4));

            add(new Entity("thailand",100,"ss",10));
            add(new Entity("thailand",100,"sky",50));
            add(new Entity("thailand",100,"digi",40));

        }};

        list.stream().sorted(
                Comparator.comparing(Entity::getCountryTotalNum,Comparator.reverseOrder()).
                        thenComparing(Entity::getCountryName).
                        thenComparing(Entity::getCustomerTotalNum,Comparator.reverseOrder()).
                        thenComparing(Entity::getCustomerName)
        ).forEach(o-> System.out.println(o.toString()));



    }
}

class Entity {
    private String countryName;
    private String customerName;
    private int countryTotalNum;
    private int customerTotalNum;

    public Entity(String countryName, int countryTotalNum, String customerName, int customerTotalNum) {
        this.countryName = countryName;
        this.customerName = customerName;
        this.countryTotalNum = countryTotalNum;
        this.customerTotalNum = customerTotalNum;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCountryTotalNum() {
        return countryTotalNum;
    }

    public void setCountryTotalNum(int countryTotalNum) {
        this.countryTotalNum = countryTotalNum;
    }

    public int getCustomerTotalNum() {
        return customerTotalNum;
    }

    public void setCustomerTotalNum(int customerTotalNum) {
        this.customerTotalNum = customerTotalNum;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "countryName='" + countryName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", countryTotalNum=" + countryTotalNum +
                ", customerTotalNum=" + customerTotalNum +
                '}';
    }
}
