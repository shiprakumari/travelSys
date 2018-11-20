package com.cg.paymentwallet.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.cg.paymentwallet.bean.AccountBean;
import com.cg.paymentwallet.bean.CustomerBean;
import com.cg.paymentwallet.exception.CustomerException;

public interface IAccountDao {


    public boolean createAccount(AccountBean accountBean) throws CustomerException ;
    public boolean updateAccount(AccountBean accountBean) throws Exception;
    public AccountBean findAccount(int accountId) throws Exception;
  
  
	
	 
    
}
