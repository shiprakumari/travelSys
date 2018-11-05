package com.cg.frs.dao;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

public interface IFlagRegistrationDAO {

	ArrayList<Integer> getAllOwnerIds();

	void FlatRegistrationDTO(FlatRegistrationDTO bean);

}
