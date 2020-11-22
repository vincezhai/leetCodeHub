package com.zwx.leetcode.exam;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class RecordItem {
    String phoneNumber;
    int okCount;
    int noCount;
    boolean isCommon;

    @Override
    public String toString() {
        return phoneNumber + " " + okCount + " " + noCount;
    }

    public RecordItem(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RecordItem(String phoneNumber, boolean isCommon) {
        this.phoneNumber = phoneNumber;
        this.isCommon = isCommon;
    }

    public RecordItem(String phoneNumber, int okCount) {
        this.phoneNumber = phoneNumber;
        this.okCount = okCount;
    }

    public RecordItem(String phoneNumber, int okCount, int noCount) {
        this.phoneNumber = phoneNumber;
        this.okCount = okCount;
        this.noCount = noCount;
    }

    public void okCountInc() {
        this.okCount++;
    }

    public void noCountInc() {
        this.noCount++;
    }

    public int getOkCount() {
        return okCount;
    }

    public void setOkCount(int okCount) {
        this.okCount = okCount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNoCount() {
        return noCount;
    }

    public void setNoCount(int noCount) {
        this.noCount = noCount;
    }
}

/**
 * 父类
 */

class NumberList {
    ArrayList<RecordItem> recordItemList = new ArrayList<>();

    private boolean checkCommon(String phoneNumber, String commonNumber) {
        for (int i = 0; i < commonNumber.length() - 1; i++) {
            if (phoneNumber.charAt(i) != commonNumber.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isIn(String phoneNumber) {
        for (int i = 0; i < this.recordItemList.size(); i++) {
            RecordItem recordItem = this.recordItemList.get(i);
            if (!recordItem.isCommon) {
                if (phoneNumber.equals(recordItem.getPhoneNumber())) {
                    return true;
                }
            } else {
                if (checkCommon(phoneNumber, recordItem.phoneNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    public RecordItem getItemByNumber(String phoneNumber) {
        RecordItem recordItem;
        for (int i = 0; i < this.recordItemList.size(); i++) {
            recordItem = this.recordItemList.get(i);
            if (recordItem.phoneNumber.equals(phoneNumber)) {
                return recordItem;
            }
        }
        return null;
    }
}

/**
 * 白名单
 */

class WhiteRecord extends NumberList {
    public void addWhiteRecord(String number) {
        this.recordItemList.add(new RecordItem(number));
    }

    public void addWhiteRecord(String number, boolean isCommon) {
        this.recordItemList.add(new RecordItem(number, isCommon));
    }
}

/**
 * 通话记录
 */

class PhoneList extends NumberList {
    public void addPhoneList(String number) {
        this.recordItemList.add(new RecordItem(number));
    }

    public void addPhoneList(String number, int okCount) {
        this.recordItemList.add(new RecordItem(number, okCount));
    }

    public void addPhoneList(String number, int okCount, int noCount) {
        this.recordItemList.add(new RecordItem(number, okCount, noCount));
    }
    public void print() {
        for (int i = 0; i < this.recordItemList.size(); i++) {
            System.out.println(this.recordItemList.get(i).toString());
        }
    }
}


/**
 * OJ考题代码：儿童手表骚扰电话拦截 * * @author 命题组 * @since 2020-01-07
 */

public class WatchWhitList {
    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int recordNum = Integer.valueOf(cin.nextLine());
        List<String> records = new ArrayList<>(recordNum);
        for (int i = 0; i < recordNum; i++) {
            records.add(cin.nextLine());
        }
        cin.close();
        PhoneList list = count(records);
        list.print();
    }

    private static boolean isContainsStar(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '*') {
                return true;
            }
        }
        return false;
    }

    private static PhoneList count(List<String> records) {
        PhoneList phoneList = new PhoneList();
        WhiteRecord whiteRecord = new WhiteRecord();

        for (int i = 0; i < records.size(); i++) {
            String commandLine = records.get(i);
            String[] commands = commandLine.split(" ");
            String op = commands[0];
            String number = commands[1];
            switch (op) {
                case "C": {
                    if (whiteRecord.isIn(number)) {
                        if (phoneList.isIn(number)) {
                            phoneList.getItemByNumber(number).okCount++;
                        } else {
                            phoneList.addPhoneList(number, 1);
                        }
                    } else {
                        if (phoneList.isIn(number)) {
                            phoneList.getItemByNumber(number).noCount++;
                        } else {
                            phoneList.addPhoneList(number, 0, 1);
                        }
                    }
                    break;
                }
                case "W": {
                    if (isContainsStar(number)) {
                        whiteRecord.addWhiteRecord(number, true);
                    } else {
                        whiteRecord.addWhiteRecord(number);
                    }
                    break;
                }
            }
        }
        return phoneList;
    }
}