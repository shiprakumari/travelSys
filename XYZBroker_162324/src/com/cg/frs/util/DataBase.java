package com.cg.frs.util;

import java.util.ArrayList;

import com.cg.frs.dto.FlatRegistrationDTO;

public class DataBase {
	private static ArrayList<Integer> ownerDetails = new ArrayList<>();
	private static ArrayList<FlatRegistrationDTO> flat_Registration = new ArrayList<>();
	public static ArrayList<Integer> getAllOwnerIds() {
		ownerDetails.add(1);
		ownerDetails.add(2);
		ownerDetails.add(3);
		return ownerDetails;
	}
	public static void FlatRegistrationDTO(FlatRegistrationDTO bean) {
		flat_Registration.add(bean);
	}

}
