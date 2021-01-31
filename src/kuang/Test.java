package kuang;

import java.text.Collator;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Entity> list = new ArrayList<Entity>(){{
            add(new Entity("中国",0,"中国",0));
            add(new Entity("重庆",0,"重庆",0));
            add(new Entity("安徽",0,"安徽",0));
            add(new Entity("上海",0,"上海",0));
        }};

        list.stream().sorted(
                (o1,o2)-> Collator.getInstance(Locale.CHINA).
                                compare(o1.getCountryName().replace("重庆","冲庆"),
                                        o2.getCountryName().replace("重庆","冲庆"))).
                forEach(o-> System.out.println(o));


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
