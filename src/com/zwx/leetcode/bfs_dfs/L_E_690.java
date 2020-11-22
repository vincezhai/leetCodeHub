package com.zwx.leetcode.bfs_dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_E_690 {
    public static void main(String[] args) {

    }

    public static int getImportance(List<Employee> employees, int id) {
        int res = 0;
        if(employees == null){
            return res;
        }
        // hashMap
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee employee : employees){
            map.put(employee.id,employee);
        }
        // bfs
        Queue<Employee> queue = new LinkedList();
        //queue.offer(getEmployee(employees,id));
        queue.offer(map.get(id));
        // 遍历
        while (!queue.isEmpty()){
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                Employee currEmployee = queue.poll();
                res += currEmployee.importance;
                if(currEmployee.subordinates != null){
                    for (Integer subId : currEmployee.subordinates) {
                        //queue.offer(getEmployee(employees,subId));
                        queue.offer(map.get(subId));
                    }
                }
            }
        }
        return res;
    }

    public static Employee getEmployee(List<Employee> employees, int id){
        //Employee employee = new Employee();
        for (Employee currEmplyee : employees) {
            if(currEmplyee.id == id){
                return currEmplyee;
            }
        }
        return null;
    }

}
