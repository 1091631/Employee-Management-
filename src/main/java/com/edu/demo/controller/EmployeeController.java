package com.edu.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.demo.entity.Department;
import com.edu.demo.entity.Employee;
import com.edu.demo.error.DepartmentNotFoundException;
import com.edu.demo.error.EmployeeNotFoundException;
import com.edu.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/director/")//get all record by employee
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/director/{managerId}")  //get all recored find by mangerId
	public List<Employee> getByManagerId(@PathVariable int managerId) throws EmployeeNotFoundException {
		return service.getByManagerId(managerId);
	}
	
	@GetMapping("/director/departments") //for fetch departments
	public List<Department> getDepartments(){
		return service.getDepartments();
		
	}
	@GetMapping("/director/department/{deptId}")
	public Department getDepartment(@PathVariable int deptId)throws DepartmentNotFoundException{
		return service.getDepartment(deptId);
	}
	@PostMapping("/director/addDept")
	public Department addDepartment(@RequestBody Department dept) {
		return service.addDepartment(dept);
	}
	
	@PutMapping("/director/department/update/{deptId}")
	public Department updateDepartment(@RequestBody Department dept,@PathVariable int deptId) throws DepartmentNotFoundException{
		return service.updateDepartment(deptId, dept);
	}
	
	@DeleteMapping("/director/department/{deptId}")
	public String deleteDepartment(@PathVariable int deptId) throws DepartmentNotFoundException {
		return service.deleteDepartment(deptId);
	}
	
	@PostMapping("/director/addEmp/{deptId}")
	public Employee addEmployee(@RequestBody Employee emp,@PathVariable int deptId) throws DepartmentNotFoundException, EmployeeNotFoundException{
		return service.addEmployee(deptId, emp);
	}
	@PutMapping("/director/user/{empId}")
	public Employee updateuser(@RequestBody Employee emp,@PathVariable int empId)throws EmployeeNotFoundException {
	return service.updateuser(empId,emp);
	}
	
	@DeleteMapping("/director/delete/{empId}")
	public String deleteUser(@PathVariable int empId) throws EmployeeNotFoundException{
	return service.deleteUser(empId);
	}
	
	@PutMapping("/director/updateself/{empId}")
	public Employee updateSelfByDirector(@RequestBody Employee emp,@PathVariable int empId)throws EmployeeNotFoundException{
		return service.updateSelfByDirector(emp,empId);
	}
	
	@GetMapping("/manager/getemp/{empId}")
	public List<Employee> getEmployees(@PathVariable int empId) throws EmployeeNotFoundException {
		return service.getEmployee(empId);
		
	}
	
	@PostMapping("/manager/{deptId}")
	public Employee addEmployeeByManager(@PathVariable int deptId,@RequestBody Employee emp )throws EmployeeNotFoundException, DepartmentNotFoundException{
		return service.addEmpolyeeByManager(deptId,emp);
	}
@PutMapping("/manager/update/{empId}")
public Employee updateEmployeeByManager(@PathVariable int empId,@RequestBody Employee emp)throws EmployeeNotFoundException{
	return service.updateEmployeeByManager(empId ,emp);
}

@PutMapping("/manager/updateself/{empId}")
public Employee updateselfEmployeeByManager(@PathVariable int empId,@RequestBody Employee emp) throws EmployeeNotFoundException{
	return service.updateSelfEmployeeByManager(emp, empId);
}

@DeleteMapping("/manager/delete{empId}")
public  String deleteEmployeeByManager(@PathVariable int empId)throws EmployeeNotFoundException{
	return service.deleteEmployeeByMAnager(empId);
	
}

@PutMapping("/employee/update/{empId}")
public Employee updateSelfByEmployee(@PathVariable int empId,@RequestBody Employee emp)throws EmployeeNotFoundException{
	return service.updateSelfByEmployee(empId,emp);
	
}
@GetMapping("/director/getOne/{empId}")//new
public Employee getOne(@PathVariable int empId) throws EmployeeNotFoundException {
	return service.getOne(empId);
}

@GetMapping("/director/getByDate/{date}")//new
public void getByJoiningDate(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date) throws EmployeeNotFoundException{
	return;
}

}

