package com.cg.paymentwallet.test;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.paymentwallet.bean.AccountBean;
import com.cg.paymentwallet.bean.CustomerBean;
import com.cg.paymentwallet.dao.AccountDAOImpl;
import com.cg.paymentwallet.dao.IAccountDao;
import com.cg.paymentwallet.exception.CustomerException;
import com.cg.paymentwallet.service.AccountServiceImpl;
import com.cg.paymentwallet.service.IAccountService;

public class AccountServiceImplTest {

	private static IAccountService accountService = null;
	private static AccountBean accBean = null;
	private static CustomerBean cusBean = null;
	private static IAccountDao accountDAO = null;

	@BeforeClass
	public static void createInstance() {
		accountService = new AccountServiceImpl();
		accBean = new AccountBean();
		cusBean = new CustomerBean();
		accountDAO = new AccountDAOImpl();
	}

	/*
	@Test
	public void testCreateAccount() throws Exception {
		cusBean.setFirstName("puja");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(101);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(101);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		boolean result = accountService.createAccount(accBean);
		assertTrue(result);
	}

	@Test(expected = CustomerException.class)
	public void testCreateAccountForName() throws CustomerException {
		cusBean.setFirstName("");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(101);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(101);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		boolean result = accountService.createAccount(accBean);
		assertFalse(result);
	}*/

	@Test
	public void testWithdrawForPositive() throws Exception {
		cusBean.setFirstName("puja");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(100);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(100);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		boolean result = accountService.withdraw(accBean, 1000.00);
		Assert.assertEquals(true, result);

	}

	@Test
	public void testWithdrawForNegative() throws Exception {
		cusBean.setFirstName("puja");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(100);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(100);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		boolean result = accountService.withdraw(accBean, 1000.00);
		assertNotSame(100.00, result);

	}

	@Test
	public void testDepopsitForNegative() throws Exception {
		cusBean.setFirstName("puja");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(100);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(100);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		boolean result = accountService.deposit(accBean, 1000.00);
		assertNotSame(100.00, result);

	}

	@Test
	public void testDepositForPositive() throws Exception {
		cusBean.setFirstName("puja");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(100);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(100);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		boolean result = accountService.deposit(accBean, 1000.00);
		assertEquals(true, result);

	}
	@Test
	public void testFundTransferForPositive() throws Exception {
		cusBean.setFirstName("puja");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(100);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(100);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		AccountBean accBean1 = new AccountBean();
		CustomerBean bean = new CustomerBean();
		
		bean.setFirstName("puja");
		bean.setLastName("Devi");
		bean.setCustomerId(101);
		bean.setAddress("Hyderabad");
		bean.setEmailId("pooja.gmail.com");
		bean.setPanNum("ABGRT45423");
		bean.setPhoneNo("9087561234");
		accBean1.setAccountId(101);
		accBean1.setCustomerBean(cusBean);
		accBean1.setBalance(5000.00);
		accBean1.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean1.setInitialDeposit(2000.00);
		accBean1.setCustomerBean(cusBean);
		
		
		
		boolean result = accountService.fundTransfer(accBean, accBean1, 1000.00);
		assertEquals(true, result);

	}
	@Test
	public void testFundTransferForNegative() throws Exception {
		cusBean.setFirstName("puja");
		cusBean.setLastName("Devi");
		cusBean.setCustomerId(100);
		cusBean.setAddress("Hyderabad");
		cusBean.setEmailId("pooja.gmail.com");
		cusBean.setPanNum("ABGRT45423");
		cusBean.setPhoneNo("9087561234");
		accBean.setAccountId(100);
		accBean.setCustomerBean(cusBean);
		accBean.setBalance(5000.00);
		accBean.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean.setInitialDeposit(2000.00);
		accBean.setCustomerBean(cusBean);
		AccountBean accBean1 = new AccountBean();
		CustomerBean bean = new CustomerBean();
		
		bean.setFirstName("puja");
		bean.setLastName("Devi");
		bean.setCustomerId(101);
		bean.setAddress("Hyderabad");
		bean.setEmailId("pooja.gmail.com");
		bean.setPanNum("ABGRT45423");
		bean.setPhoneNo("9087561234");
		accBean1.setAccountId(101);
		accBean1.setCustomerBean(cusBean);
		accBean1.setBalance(5000.00);
		accBean1.setDateOfOpening(new Date(15 / 11 / 2018));
		accBean1.setInitialDeposit(2000.00);
		accBean1.setCustomerBean(cusBean);
		
		
		
		boolean result = accountService.fundTransfer(accBean, accBean1, 1000.00);
		assertNotEquals(100.00, result);

	}
	
	

}
