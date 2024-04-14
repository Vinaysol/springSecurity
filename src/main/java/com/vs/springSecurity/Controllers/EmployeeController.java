package com.vs.springSecurity.Controllers;

import com.vs.springSecurity.Models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("/EmployeeManagement/v1")
public class EmployeeController {

    public static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(1, "Vinay"));
        employeeList.add(new Employee(2, "Sakshi"));

    }
    
    @GetMapping("/employees")
    List<Employee> all() {
        return employeeList;
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        employeeList.add(newEmployee);
        return newEmployee;
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable int id) {
        return employeeList.get( id);
    }
}