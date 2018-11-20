package com.cg.paymentwallet.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cg.paymentwallet.bean.AccountBean;
import com.cg.paymentwallet.bean.CustomerBean;
import com.cg.paymentwallet.exception.CustomerException;

public interface IAccountService {

          public boolean createAccount(AccountBean accountBean) throws  CustomerException ;
          public AccountBean findAccount(int accountId) throws Exception;
          public boolean deposit(AccountBean accountBean,double depositAmount) throws Exception ;
          public boolean withdraw(AccountBean accountBean,double withdrawAmount) throws Exception;
          public boolean fundTransfer(AccountBean transferingAccountBean, AccountBean beneficiaryAccountBean, double transferAmount) throws Exception ;
          public boolean validate(CustomerBean customer,AccountBean accountBean) throws CustomerException;
		 
          
	
}
