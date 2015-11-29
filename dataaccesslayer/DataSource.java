package dataaccesslayer;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

/**
 * <h3>Class: DataSource.java</h3>
 * <h4>Description:</h4> 
 * DataSource.java will be used to establish a connection to the database. 
 * 
 * @version   1.0.0 Nov 18, 2015
 */
public class DataSource {
	/** connection will contain a Connection value.*/
	private Connection connection= null;
	/** connectionString will contain a String value. used to hold the address of the database.*/
	private String connectionString = "jdbc:mysql://localhost:3306/PotLuck.db";
	/** userName will contain a String value. used to provide a userName to connect to the database.*/
	private String userName = "scott";
	/** password will contain a String value. used to provide a password to connect to the database.*/
	private String password = "tiger";
	/**
	 *	Default constructor.
	 */
	public DataSource(){}
	/**
	 *	Parameterize constructor.
	 *	@return	connection	will return a Connection.
	 */
	public Connection createConnection(){ 
		try{//attempt connection
			
			if(connection != null){
				System.out.println("Cannot create new connection, one exists already");
			}
			else{
				
				connection = DriverManager.getConnection(connectionString, userName, password);
				
			}
		}catch(SQLException sqle){
			System.err.println(sqle.getMessage());
		}
		return connection;
	}
}//end DataSource

