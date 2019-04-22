package com.tw.springbootbasis.service;

import com.tw.springbootbasis.data.EmployeeData;
import com.tw.springbootbasis.entity.Employee;
import com.tw.springbootbasis.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeData = EmployeeData.employeeData();

    public List<Employee> getAllEmployee() {
        return employeeData;
    }

    public void addEmployee(Employee employee) {

        employeeData.add(employee);
    }

    public void updateEmployeeById(int employeeId, Employee employee) throws BusinessException {
        Employee employeeInfo = getEmployeeById(employeeId);
        employeeInfo.setName(employee.getName());
        save(employeeInfo);
    }

    public void deleteEmployeeById(int employeeId) throws BusinessException {
        deleteById(employeeId);
    }

    private Employee getEmployeeById(int employeeId) throws BusinessException {
        return employeeData.stream()
                .filter(item -> item.getId() == employeeId)
                .findFirst()
                .orElseThrow(() -> new BusinessException(
                        String.format("Unknown Employee with id: %s", employeeId)
                ));
    }

    private void save(Employee employeeInfo) {
        int index = 0;
        for(int i = 0; i<employeeData.size(); i++){
            if(employeeData.get(i).getId() == employeeInfo.getId()){
                index = i;
            }
        }
        employeeData.set(index, employeeInfo);
    }

    private void deleteById(int employeeId) throws BusinessException {
        Employee employee = getEmployeeById(employeeId);
        employeeData.remove(employee);
    }
}
