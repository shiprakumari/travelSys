package com.cg.frs.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exception.RegistrationException;
import com.cg.frs.service.FlagRegistrationServiceImpl;
import com.cg.frs.service.IFlagRegistrationService;

public class Client {

	public static void main(String[] args) throws RegistrationException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("-----XYZ Broker-----");
		System.out.println("1. Register Flat");
		System.out.println("2. Exit");
		int option = scanner.nextInt();
		if (option == 1) {
			FlatRegistrationDTO bean = new FlatRegistrationDTO();
			IFlagRegistrationService service = new FlagRegistrationServiceImpl();
			ArrayList<Integer> ownerDetails = service.getAllOwnerIds();
			System.out.println("Existing Owner Id's Are: " + ownerDetails);
			System.out.println("Please Enter Your Owner id From Above List:");
			int choice = scanner.nextInt();
			// Set Owner id
			bean.setOwnerIds(choice);
			/*
			 * for (Integer ids : ownerDetails) { if (condition) {
			 * 
			 * } else {
			 * 
			 * } }
			 */
			// Set Flat Id
			int flatId = (int) (Math.random() * 10000);
			bean.setFlatId(flatId);
			// Set Flat Type
			System.out.println("Select Flat type");
			System.out.println("1-1BHK , 2-2BHK");
			int choice1 = scanner.nextInt();
			if (choice1 == 1) {
				bean.setFlatType("1BHK");
			} else if (choice1 == 2) {
				bean.setFlatType("2BHK");
			}
			// Set Flat Area
			System.out.println("Enter Flat area in sq. ft.: ");
			int flatArea = scanner.nextInt();
			bean.setFlatId(flatArea);
			// Set Flat rent
			System.out.println("Enter desired rent amount Rs: ");
			int rent = scanner.nextInt();
			bean.setRent(rent);
			// Set Flat deposite
			System.out.println("Enter desired deposit amount Rs: ");
			int deposite = scanner.nextInt();
			if (deposite <= rent) {
				throw new RegistrationException();
			} else {
				bean.setDeposite(deposite);
			}
			service.FlatRegistrationDTO(bean);
			System.out.println(bean);
		}
		if (option == 2) {
			System.exit(0);
		}
	}
}
