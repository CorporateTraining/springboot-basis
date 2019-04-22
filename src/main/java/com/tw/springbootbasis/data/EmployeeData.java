package com.tw.springbootbasis.data;

import com.tw.springbootbasis.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> employeeData() {
        List<Employee> userList = new ArrayList<>();
        userList.add(new Employee(1, "小明", 22, "男"));
        userList.add(new Employee(2, "小红", 21, "女"));
        userList.add(new Employee(3, "小花", 20, "女"));
        return userList;
    }
}
