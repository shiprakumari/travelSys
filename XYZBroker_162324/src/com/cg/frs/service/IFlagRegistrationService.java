package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

public interface IFlagRegistrationService {

	ArrayList<Integer> getAllOwnerIds();

	void FlatRegistrationDTO(FlatRegistrationDTO bean);
	

}
