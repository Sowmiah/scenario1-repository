package com.test.practise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.practise.model.EmpModel;

@Service
public class DownloadServiceImpl implements DownloadService{

	@Override
	public List<EmpModel> getEmpDetails() {
		
		List<EmpModel> empList = new ArrayList<EmpModel>();
		
		EmpModel emp1 = new EmpModel("SSSS","21","Male");
		EmpModel emp2 = new EmpModel("fhfg","26","Female");
		EmpModel emp3 = new EmpModel("vnvbn","28","Male");
		EmpModel emp4 = new EmpModel("bnvb","29","Female");
		EmpModel emp5 = new EmpModel("erw","22","Male");
		EmpModel emp6 = new EmpModel("zsfds","25","Male");
		
		empList = Arrays.asList(emp1,emp2,emp3,emp4,emp5,emp6);
		
		return empList;
	}

	
}
