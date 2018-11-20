package com.cg.paymentwallet.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.paymentwallet.bean.AccountBean;
import com.cg.paymentwallet.bean.CustomerBean;
import com.cg.paymentwallet.bean.WalletTransaction;
import com.cg.paymentwallet.exception.CustomerException;
import com.cg.paymentwallet.service.AccountServiceImpl;
import com.cg.paymentwallet.service.IAccountService;

public class Client {

	IAccountService service = new AccountServiceImpl();
	CustomerBean customer = new CustomerBean();
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		char ch;
		Client client = new Client();
		do {
			System.out.println("========Payment wallet application========");
			System.out.println("1. Create Account ");
			System.out.println("2. Show Balance ");
			System.out.println("3. Deposit ");
			System.out.println("4. Withdraw ");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transactions");
			System.out.println("7. Exit");
			System.out.println("Choose an option");
			int option = client.scanner.nextInt();

			switch (option) {
			case 1:
				client.create();
				break;
			case 2:
				client.showbalance();

				break;

			case 3:
				client.deposit();

				break;

			case 4:
				client.withdraw();

				break;

			case 5:
				client.fundtransfer();

				break;

			case 6:
				client.printTransaction();

				break;
			case 7:
				System.exit(0);

				break;

			default:
				System.out.println("invalid option");
				break;
			}

			System.out.println("Do you want to continue press Y/N");
			ch = client.scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

	/*
	 *  method to create the account for customer
	 */
	void create() throws Exception {

		System.out.print("\t Enter Customer firstname  : ");
		String fname = scanner.next();

		System.out.print("\t Enter Customer lastname  : ");
		String lname = scanner.next();

		System.out.println("\t Enter  Customer  email id  : ");
		String email = scanner.next();

		System.out.println("\t Enter  Customer  phone number  : ");
		String phone = scanner.next();

		System.out.println("\t Enter  Customer PAN number  : ");
		String pan = scanner.next();

		System.out.println("\t Enter  Customer  address  : ");
		String address = scanner.next();
		/*
		 * Creating a customerbean class object to set the values for account 
		 */
		int customer_Id = (int) (Math.random() * 1000);
		CustomerBean customerBean = new CustomerBean();
		customerBean.setCustomerId(customer_Id);
		customerBean.setAddress(address);
		customerBean.setEmailId(email);
		customerBean.setPanNum(pan);
		customerBean.setPhoneNo(phone);
		customerBean.setFirstName(fname);
		customerBean.setLastName(lname);
		
		System.out.println("Enter Date of Opening (DD/MM/YYYY)");
		String accDateInput = scanner.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfOpeining = sdf.parse(accDateInput);

		System.out.println("Enter balance to create account");
		double balance = scanner.nextDouble();
		/*
		 * Creating a accountbean class object to set the values for account 
		 */
		int account_id = (int) (Math.random() * 1000);
		AccountBean accountBean = new AccountBean();
		
		accountBean.setAccountId(account_id);
		accountBean.setBalance(balance);
		//accountBean.setInitialDeposit(balance);
		accountBean.setCustomerBean(customerBean);
		accountBean.setDateOfOpening(dateOfOpeining);

		if (service.validate(customerBean, accountBean)) {
			boolean result = service.createAccount(accountBean);
			if (result) {
				System.out
						.println("\n\n\t Congratulations Customer account has been created successfully with Customer id: " 
				+customerBean.getCustomerId()+"Account id is :"+accountBean.getAccountId() +"\n\n\t");
			} else {
				System.out.println("Enter valid details..");
			}
		}

	}
/*
 * method to show the balance for a particular Account
 */
	void showbalance() throws CustomerException, Exception {
		System.out.println("Enter Account ID");
		int accId = scanner.nextInt();

		AccountBean accountBean = service.findAccount(accId);

		if (accountBean == null) {
			System.out.println("Account Does not exist");
			return;
		}

		double balance = accountBean.getBalance();
		String fname = accountBean.getCustomerBean().getFirstName();
		String lname = accountBean.getCustomerBean().getLastName();
		String add = accountBean.getCustomerBean().getAddress();
		System.out.print(" your Account details are:");
		System.out.print("\t Your balance is: " + balance);
		System.out.print("\t Customer name is: " + fname + " " + lname);
		System.out.println("\t\t Customer address is: " + add);

	}
/*
 * method to do the deposit operation
 */
	void deposit() throws Exception {
		System.out.println("Enter Account ID");
		int accId = scanner.nextInt();
		
		AccountBean accountBean = service.findAccount(accId);
		
		double balance = accountBean.getBalance();
		String fname = accountBean.getCustomerBean().getFirstName();
		String lname = accountBean.getCustomerBean().getLastName();
		String add = accountBean.getCustomerBean().getAddress();
		
		System.out.print(" your Account details are:");
		System.out.print("\t Your balance is: " + balance);
		System.out.print("\t Customer name is: " + fname + " " + lname);
		System.out.println("\t\t Customer address is: " + add);

		System.out.println("Enter amount that you want to deposit");
		double depositAmt = scanner.nextDouble();
		
		WalletTransaction wt = new WalletTransaction();
		wt.setTransactionType(1);
		wt.setTransactionDate(new Date());
		wt.setTransactionAmt(depositAmt);
		wt.setBeneficiaryAccountBean(null);

		accountBean.addTransation(wt);
		if (accountBean == null) {
			System.out.println("Account Does not exist");
			return;
		}

		boolean result = service.deposit(accountBean, depositAmt);

		if (result) {
			System.out.println("Deposited Money into Account "
					+ "Current balance is :" + accountBean.getBalance());
		} else {
			System.out.println("NOT Deposited Money into Account ");
		}

	}
//method to  withdraw money from account 
	void withdraw() throws Exception {
		System.out.println("Enter Account ID");
		int accId = scanner.nextInt();
		AccountBean accountBean = service.findAccount(accId);
		double balance = accountBean.getBalance();
		String fname = accountBean.getCustomerBean().getFirstName();
		String lname = accountBean.getCustomerBean().getLastName();
		String add = accountBean.getCustomerBean().getAddress();
		System.out.print(" your Account details are:");
		System.out.print("\t Your balance is: " + balance);
		System.out.print("\t Customer name is: " + fname + " " + lname);
		System.out.println("\t\t Customer address is: " + add);

		System.out.println("Enter amount that you want to withdraw");
		double withdrawAmt = scanner.nextDouble();

		if (accountBean.getBalance() > withdrawAmt) {
			WalletTransaction wt = new WalletTransaction();
			wt.setTransactionType(2);
			wt.setTransactionDate(new Date());
			wt.setTransactionAmt(withdrawAmt);
			wt.setBeneficiaryAccountBean(null);

			accountBean.addTransation(wt);

			if (accountBean == null) {
				System.out.println("Account Does not exist");
				return;
			}

			boolean result = service.withdraw(accountBean, withdrawAmt);
			if (result) {
				System.out.println("Withdaw Money from Account done"
						+ "Current balance is :" + accountBean.getBalance());
			} else {
				System.out.println("Withdaw Money from Account -Failed ");
			}
		} else {
			System.err.println("insufficient amount");
		}

	}

	void fundtransfer() throws Exception {
		System.out.println("Enter Account ID to Transfer Money From");

		int srcAccId = scanner.nextInt();

		AccountBean accountBean1 = service.findAccount(srcAccId);
		// 1st account details
		double balance = accountBean1.getBalance();
		String fname = accountBean1.getCustomerBean().getFirstName();
		String lname = accountBean1.getCustomerBean().getLastName();
		String add = accountBean1.getCustomerBean().getAddress();
		System.out.print(" your Account details are:");
		System.out.print("\t Your balance is: " + balance);
		System.out.print("\t Customer name is: " + fname + " " + lname);
		System.out.println("\t\t Customer address is: " + add);

		System.out.println("Enter Account ID to Transfer Money to");
		int targetAccId = scanner.nextInt();
		// 2nd account details
		AccountBean accountBean2 = service.findAccount(targetAccId);
		double balance1 = accountBean2.getBalance();
		String fname1 = accountBean2.getCustomerBean().getFirstName();
		String lname1 = accountBean2.getCustomerBean().getLastName();
		String add1 = accountBean2.getCustomerBean().getAddress();
		System.out.print(" your Account details are:");
		System.out.print("\t Your balance is: " + balance1);
		System.out.print("\t Customer name is: " + fname1 + " " + lname1);
		System.out.println("\t\t Customer address is: " + add1);

		System.out.println("Enter amount that you want to transfer");
		double transferAmt = scanner.nextDouble();
		if (accountBean1.getBalance() > transferAmt) {

			WalletTransaction wt = new WalletTransaction();
			wt.setTransactionType(3);
			wt.setTransactionDate(new Date());
			wt.setTransactionAmt(transferAmt);
			wt.setBeneficiaryAccountBean(accountBean2);

			accountBean1.addTransation(wt);
			WalletTransaction trans = new WalletTransaction();
			trans.setTransactionType(3);
			trans.setTransactionDate(new Date());
			trans.setTransactionAmt(transferAmt);
			trans.setBeneficiaryAccountBean(null);

			accountBean2.addTransation(trans);

			boolean result = service.fundTransfer(accountBean1, accountBean2,
					transferAmt);

			if (result) {
				System.out.println("Transfering Money from Account done"
						+ "Current balance of your account is  :"
						+ accountBean1.getBalance());
			} else {
				System.out.println("Transfering Money from Account Failed ");
			}
		} else {
			System.err.println("insufficient amount");
		}

	}

	void printTransaction() throws Exception {
		System.out
				.println("Enter Account ID (for printing Transaction Details)");
		int accId = scanner.nextInt();

		AccountBean accountBean = service.findAccount(accId);

		List<WalletTransaction> transactions = accountBean.getAllTransactions();

		System.out.println(accountBean);
		System.out.println(accountBean.getCustomerBean());

		System.out
				.println("------------------------------------------------------------------");
		System.out.println("Transaction type");
		for (WalletTransaction wt : transactions) {

			String str = "";
			if (wt.getTransactionType() == 1) {
				str = str + "DEPOSIT";
			}
			if (wt.getTransactionType() == 2) {
				str = str + "WITHDRAW";
			}
			if (wt.getTransactionType() == 3) {
				str = str + "FUND TRANSFER";
			}

			str = str + "\t\t" + wt.getTransactionDate();

			str = str + "\t\t" + wt.getTransactionAmt();
			System.out.println(str);
		}

		System.out
				.println("------------------------------------------------------------------");

	}

}
