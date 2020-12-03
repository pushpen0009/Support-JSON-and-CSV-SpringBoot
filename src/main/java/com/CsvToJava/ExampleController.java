package com.CsvToJava;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
	@GetMapping(value="ping")
	public String ping() {
		return "success";
	}
    
    @RequestMapping(
              value = "/newEmployee",
              consumes = {"application/json", "file/csv"},
              method = RequestMethod.POST)
    public String handleRequest (@RequestBody EmployeeList employeeList) {
        System.out.printf("In handleRequest method, employeeList: %s%n", employeeList.getList());
        String s = String.format("size: " + employeeList.getList().size());
        System.out.println(s);
        return s;
    }
    
    @RequestMapping(
              value = "/employeeList",
              produces = "text/csv",
              method = RequestMethod.GET)
    public EmployeeList handleRequest2 () {
        List<Employee> list = Arrays.asList(
                  new Employee("1", "Tina", "111-111-1111"),
                  new Employee("2", "John", "222-222-2222")
        );
        EmployeeList employeeList = new EmployeeList();
        employeeList.setList(list);
        return employeeList;
    }
}