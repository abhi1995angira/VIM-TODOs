package com.cg.util;

import com.cg.dao.CarDAO;
import com.cg.dao.impl.JDBCCarDAO;

//TODO 1 Import appropriate packages based on TODOs 2 and 3

//Follow TODOs (if available)
/**
 * 
 * This is a DBUtility class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */
public class DBUtility {
	private static CarDAO carDAO = (CarDAO) new JDBCCarDAO();
	public static CarDAO getCarDAO() {
		// TODO Auto-generated method stub
		
		return carDAO;
	}
	//TODO 2 Declare a static reference dao of type CarDAO pointing to JDBCCarDAO instance
		
	/**
	 * @return	CarDAO a factory for creating DAO 
	 */
	 //TODO 3 Implement a method getCarDAO which returns dao created in TODO 1
	
}
