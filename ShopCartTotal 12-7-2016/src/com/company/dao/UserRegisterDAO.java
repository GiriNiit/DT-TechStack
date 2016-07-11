package com.company.dao;

import java.util.List;
import java.sql.Date;

import com.company.model.UserRegister;

public interface UserRegisterDAO {
	public void addRegister( UserRegister register );
	public void deleteRegister( int registerId );
	public void updateRegister( UserRegister register );
	public List<UserRegister> getAllRegisters();
	public UserRegister getRegisterById( int registerId );
//	List<Register> getAllRegisters();
	//Registera getRegisteraById(int registerId);
}