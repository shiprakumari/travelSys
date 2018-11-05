package com.cg.frs.dao;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.util.DataBase;

public class FlagRegistrationDAOImpl implements IFlagRegistrationDAO {

	@Override
	public ArrayList<Integer> getAllOwnerIds() {
		return DataBase.getAllOwnerIds();
	}

	@Override
	public void FlatRegistrationDTO(FlatRegistrationDTO bean) {
		DataBase.FlatRegistrationDTO(bean);
	}
	
}
