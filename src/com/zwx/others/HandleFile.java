package com.zwx.others;

import com.sun.jmx.snmp.SnmpNull;

import java.io.*;
import java.util.Arrays;

public class HandleFile {
    public static void main(String[] args) {
        // file
        File inputFile = new File("resourse/tmp");
        File outFile = new File("resourse/out");
        if(!inputFile.exists() || !inputFile.isFile()){
            return;
        }

        // try with resourse
        String buffer = null;
        try (BufferedReader fr = new BufferedReader(new FileReader(inputFile));
             FileWriter fw = new FileWriter(outFile);
        ){
            while ((buffer = fr.readLine()) != null){
                fw.write(convertSr(buffer) + '\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String convertSr ( String input ){
        String[] strArray = null;
        try {
            strArray = new String[2];
        } catch (ArrayIndexOutOfBoundsException exp){
            System.out.println("一行中有多个value");
        }

        if(input.contains("values")){
            strArray = input.split("values ");
        } else if (input.contains("VALUES")) {
            strArray = input.split("VALUES ");
        } else {
            return input;
        }

        String startHalf = strArray[0];
        String endHalf = "values " +  strArray[1];
        return startHalf.toLowerCase().replaceAll("`","\"").replace("\"school\".","") + endHalf;
    }
}
