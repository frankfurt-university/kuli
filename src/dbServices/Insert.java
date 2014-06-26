/**
 * 
 */
package dbServices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author NET
 *
 */
public class Insert {

	/**
	 * 
	 */
	Statement stmt = null;
	Connection conn = null;
	
	public Insert(Connection conn) {
		
		this.conn = conn;
	}
        //values can be passed as parameter from here!
	public void doInsert(String table, String attribute, String add) throws SQLException{
		
                //if we do not have autoincrement id value!
		//String query = "INSERT INTO " + table + "(name,surname,id) values('alex','blabla','')";
                
               String query = "INSERT INTO " + table + "("+attribute+") values"+ "(" +add+ ")";
		
		this.stmt = this.conn.createStatement();
		this.stmt.executeUpdate(query);
                
	}
	public boolean closeDB(){
		
		boolean success = false;
		
		try {
			
			this.stmt.close();
			this.conn.close();
			success = true;
		} catch (SQLException e) {

			System.out.println("SQL Error : " + e.getMessage());
		}
		
		return success;
		
	}

}
