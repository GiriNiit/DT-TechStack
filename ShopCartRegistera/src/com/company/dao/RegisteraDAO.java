package com.company.dao;

import java.util.List;
import java.sql.Date;

import com.company.model.Registera;

public interface RegisteraDAO {
	public void addRegistera( Registera register );
	public void deleteRegistera( int registerId );
	public void updateRegistera( Registera register );
	public List<Registera> getAllRegisteras();
	public Registera getRegisteraById( int registerId );
//	List<Register> getAllRegisters();
	//Registera getRegisteraById(int registerId);
}