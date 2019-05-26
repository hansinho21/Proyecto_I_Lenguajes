package com.proyecto1.ecommerce.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto1.ecommerce.data.RolData;
import com.proyecto1.ecommerce.domain.Rol;

@Service
public class RolBusiness {

	@Autowired
	private RolData rolData;
	
	public List<Rol> findAll(){
		return rolData.findAll();
	}
	
}
