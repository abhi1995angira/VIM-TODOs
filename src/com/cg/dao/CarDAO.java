package com.cg.dao;

import java.util.*;

import com.cg.dao.impl.JDBCDaoException;
import com.cg.dto.*;

//Follow TODOs (if available)
/**
 * 
 * This is a CarDAO class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */
public interface CarDAO 
{
    public List<CarDTO> findAll() throws JDBCDaoException; 
    public CarDTO findById(int id);
    public void create(CarDTO car);
    public void update(CarDTO car);
    public void delete(String[] ids);
}