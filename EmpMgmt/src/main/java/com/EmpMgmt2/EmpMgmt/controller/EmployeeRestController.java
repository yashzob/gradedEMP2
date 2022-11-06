package com.EmpMgmt2.EmpMgmt.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.EmpMgmt2.EmpMgmt.model.Employee;
import com.EmpMgmt2.EmpMgmt.service.EmployeeService;



@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	@Autowired
	private final EmployeeService employeeService;

	public EmployeeRestController(EmployeeService cService) {
		this.employeeService = cService;
	}

	@GetMapping
	public Set<Employee> fetchAllEmployees() {
		return this.employeeService.fetchAllEmployee();
	}

	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") long employeeId) {
		
		return this.employeeService.fetchEmployeeById(employeeId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		this.employeeService.addEmployee(employee);
	}
	 
	@PostMapping
	@RequestMapping("/add")
	public String saveEmployee(Model model) {
		System.out.println(model);
		System.out.println(this.employeeService.addEmployee((Employee) model));
		return "employee";
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable("id") long employeeId) {
		this.employeeService.deleteEmployeeById(employeeId);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return this.employeeService.updateEmployee(id, employee);
}
}
