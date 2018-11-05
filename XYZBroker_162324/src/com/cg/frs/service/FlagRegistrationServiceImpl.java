package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.FlagRegistrationDAOImpl;
import com.cg.frs.dao.IFlagRegistrationDAO;
import com.cg.frs.dto.FlatRegistrationDTO;

public class FlagRegistrationServiceImpl implements IFlagRegistrationService {
	IFlagRegistrationDAO dao = new FlagRegistrationDAOImpl();

	@Override
	public ArrayList<Integer> getAllOwnerIds() {
		return dao.getAllOwnerIds();
	}

	@Override
	public void FlatRegistrationDTO(FlatRegistrationDTO bean) {
		dao.FlatRegistrationDTO(bean);
	}
}
