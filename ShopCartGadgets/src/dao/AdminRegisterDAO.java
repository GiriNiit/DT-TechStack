package com.company.dao;

import java.util.List;
import java.sql.Date;

import com.company.model.AdminRegister;

public interface AdminRegisterDAO {
	public void addRegister( AdminRegister register );
	public void deleteRegister( int registerId );
	public void updateRegister( AdminRegister register );
	public List<AdminRegister> getAllRegisters();
	public AdminRegister getRegisterById( int registerId );
//	List<Register> getAllRegisters();
}