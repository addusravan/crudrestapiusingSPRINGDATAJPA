package com.baseexample.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;


import com.baseexample.springboot.cruddemo.dao.EmployeeRepository;
import com.baseexample.springboot.cruddemo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeServiceImp implements EmployeeService {
	
	
	private EmployeeRepository employeeDao;
	
	
	
	
	
    @Autowired
	public EmployeeServiceImp(EmployeeRepository employeeDao) {
		
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> FindAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	
	public Employee findbyid(int theId) {
		Employee theEmployee=null;
		Optional<Employee> result = employeeDao.findById(theId);
		
		if(result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			
			throw new RuntimeException("did not find employee id"+theId);
		}
		return theEmployee;
	}

	@Override
	
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
             employeeDao.save(theEmployee);
	}

	@Override
	
	public void DeleteEmployee(int theId) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(theId);
	}

}
