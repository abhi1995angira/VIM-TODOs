package com.cg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.cg.dto.CarDTO;
import com.cg.util.ServiceLocator;
import com.cg.util.ServiceLocatorException;

//TO-DO 1 Import appropriate classes based on following TODOs
//Follow TODOs (if available)
/**
 * 
 * This is a JDBCCarDAO class
 * 
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */

// TO-DO 2 Implement appropriate Interface
public class JDBCCarDAO {
	// TO-DO 3 Declare a local variable datasource of type DataSource follow
	// encapsulation principle
	DataSource datasource = null;

	public JDBCCarDAO() {
		// TO-DO 4 Initialize the dataSource in TO-DO 3 using ServiceLocator API
		// TO-DO 5 If any error occur in getting this service then throw
		// ServiceLocatorException
		// with error message as 'Container Service not available'
		try {
			datasource = ServiceLocator.getDataSource("jdbc/VIMDataSource");
		} catch (ServiceLocatorException e) {
			throw e;
		}
	}

	/**
	 * This method is mapped to ADD_CAR_ACTION
	 * 
	 * @param car
	 *            a CarDTO
	 * @throws JDBCDaoException
	 */
	public void create(CarDTO car) throws JDBCDaoException {
		//TO-DO Auto-generated method stub
		Connection connection = null;

		String insertQuery = "insert into Car (MAKE,MODEL,MODEL_YEAR) values(?,?,?)";

		try {
			try {
				// TODO 6
				// Get a connection using datasource
				// Start the JDBC transaction
				// Create a PreparedStatement using insertQuery
				// Set the parameters of the PreparedStatement
				// Invoke appropriate API of JDBC to update and commit the
				// record
				Connection dbConnection = datasource.getConnection();
				Statement s = null;
				try{
					s = dbConnection.createStatement();
					int rows;
					rows = s.executeUpdate(insertQuery);
					System.out.println(rows + "record is(are) added successfully");
				} finally {
					if(s != null)
						s.close();
				}
			} catch (SQLException e) {
				// e.printStackTrace();

				if (connection != null)
					connection.rollback();
				throw e;
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting this query: " + insertQuery, e);
		}

	}

	/**
	 * This method is mapped to DELETE_CAR_ACTION
	 * 
	 * @param ids
	 *            collection of CAR ids.
	 * @throws JDBCDaoException
	 */
	public void delete(String[] ids) throws JDBCDaoException {
		Connection connection = null;
		String deleteQuery = "delete from car where id=?";

		try {
			try {
				// TODO 7
				// Get a connection using datasource
				// Start the JDBC transaction
				// Create a PreparedStatement using deleteQuery
				// Set the parameters of the PreparedStatement
				// Invoke appropriate API of JDBC to update and commit the
				// record

			} catch (SQLException e) {
				if (connection != null)
					connection.rollback();

				throw e;
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + deleteQuery, e);
		}
	}

	/**
	 * This method is mapped to EDIT_CAR_ACTION
	 * 
	 * @param car
	 *            a CarDTO
	 * @throws JDBCDaoException
	 */
	public void update(CarDTO car) throws JDBCDaoException {
		// TODO Auto-generated method stub
		String updateQuery = "update car set make=?,model=?,model_year=? where id=?";
		Connection connection = null;

		try {
			try {
				// TODO 8
				// Get a connection using datasource
				// Start the JDBC transaction
				// Create a PreparedStatement using updateQuery
				// Set the parameters of the PreparedStatement
				// Invoke appropriate API of JDBC to update and commit the
				// record

			} catch (SQLException e) {
				if (connection != null)
					connection.rollback();

				throw e;
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + updateQuery, e);
		}
	}

	/**
	 * This method is mapped to VIEW_CAR_LIST_ACTION
	 * 
	 * @return List list of cars
	 * @throws JDBCDaoException
	 */
	public List<CarDTO> findAll() throws JDBCDaoException {
		List<CarDTO> carList = new ArrayList<CarDTO>();

		Connection connection = null;
		String selectQuery = "select * from CAR";

		try {
			try {
				// TODO 9
				// Get a connection using datasource
				// Don't start the JDBC transaction
				// Create a Statement using selectQuery
				// Invoke appropriate API of JDBC to fire the query
				// For iteration over the ResultSet populate carList with CarDTO

			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + selectQuery, e);
		}

		return carList;
	}

	/**
	 * This method is utility method for finding car by id.
	 * 
	 * @param id
	 *            id of the car to be searched
	 * @return CarDTO A CarDTO
	 */
	public CarDTO findById(int id) {
		// TODO Auto-generated method stub
		String selectQuery = "select * from CAR where id=?";
		CarDTO car = new CarDTO();
		Connection connection = null;

		try {
			try {
				connection = dataSource.getConnection();
				connection.setAutoCommit(true);
				PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
				selectStatement.setInt(1, id);
				ResultSet result = selectStatement.executeQuery();
				result.next();

				car.setId(result.getInt("id"));
				car.setMake(result.getString("make"));
				car.setMake(result.getString("model"));
				car.setModelYear(result.getString("MODEL_YEAR"));
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + selectQuery, e);
		}

		return car;
	}

}
