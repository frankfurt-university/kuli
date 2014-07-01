/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbServices;

import utils.XMLOperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NET
 *
 */
public class DBServiceInvokerSemicolon {

	public Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	private String errorString = "";
        Date date = null;
        Map<String, String> credentials = null;
        
	public DBServiceInvokerSemicolon() {

            
		try {
                    
                    String path = "Config.xml";
                    XMLOperations xmlOperations = new XMLOperations();
                    xmlOperations.setXmlPath(path);
                    xmlOperations.runProcess();
                    credentials = new HashMap<String, String>();
                    credentials = xmlOperations.getElements();
                    openConnection();
                }catch (Exception e) {
			
			System.out.println("Error : " + e.getMessage());
		}
		
		
	}

	public void openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
                String urlPrefix = credentials.get("url");
                String dbName = credentials.get("db");
                String driver = credentials.get("driver");
                String userName = credentials.get("user");
                String password = credentials.get("pass");
                String port = credentials.get("port");
                String host = credentials.get("host");
                
                //Structure of this statement="jdbc:mysql://127.0.0.1:3306/"
		String url = urlPrefix + host + ":" + port + "/";
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, password);
	}
	public List<String> invokeSelect(String table, String where) throws SQLException{
		
                SelectSemicolon select = null;
                date = new Date();
		try {
			
			if(this.conn==null || this.conn.isClosed())
				openConnection();
			
			select = new SelectSemicolon(this.conn);
			select.doSelectAll(table, where);
			select.closeDB();
			
			
		} catch (Exception e) {
			
			System.out.println("IOError : " + e.getMessage());
                        errorString = "Time : " + date.toString() + " - Error Message : " + e.getMessage();
		}
                return select.getAllInfo();
		
	}
        public List<String> invokeSelectWithPreparedStatement(int id) throws SQLException{
		
                SelectSemicolon select = null;
                date = new Date();
                List<String> searchedRecords = new ArrayList<String>();
		try {
			
			if(this.conn==null || this.conn.isClosed())
				openConnection();
			
			select = new SelectSemicolon(this.conn);
			searchedRecords = select.doSelectWithPreparedStatement(id);
			select.closeDB();
		} catch (Exception e) {
			
			System.out.println("IOError : " + e.getMessage());
                        errorString = "Time : " + date.toString() + " - Error Message : " + e.getMessage();
		}
                return searchedRecords;
		
	}
        
        public boolean invokeInsert(String table,String attribute,String add){
            boolean success = false;
            Insert insert = null;
            Date date = new Date();
             try {
			
		if(this.conn==null || this.conn.isClosed())
                   openConnection();
		insert = new Insert(this.conn);
		insert.doInsert(table,attribute,add);
		insert.closeDB();
		success = true;	
            } catch (Exception e) {
			
		System.out.println("IOError : " + e.getMessage());
                errorString = "Time : " + date.toString() + " - Error Message : " + e.getMessage();
            }
            
            return success;
        }
        
        public boolean invokeUpdate(String table, String attribute, String upDate){
        
            boolean success = false;
            Update update = null;
            date = new Date();
            try {
			
		if(this.conn==null || this.conn.isClosed())
                   openConnection();
		update = new Update(this.conn);
		update.doUpdate(table,attribute,upDate);
		update.closeDB();
		success = true;	
            } catch (Exception e) {
			
		System.out.println("IOError : " + e.getMessage());
                errorString = "Time : " + date.toString() + " - Error Message : " + e.getMessage();
            }
            return success;
        }
        
        public boolean invokeDelete(String table, String attribute){
        
            boolean success = false;
            Delete delete = null;
            date = new Date();
            try {
			
		if(this.conn==null || this.conn.isClosed())
                   openConnection();
		delete = new Delete(this.conn);
		delete.doDelete(table,attribute);
		delete.closeDB();
		success = true;	
            } catch (Exception e) {
			
		System.out.println("IOError : " + e.getMessage());
                errorString = "Time : " + date.toString() + " - Error Message : " + e.getMessage();
            }
            return success;
        }
        
        /*
        public boolean invokeCreateTable(){
        
            boolean success = false;
            CreateTable createTable = null;
            date = new Date();
            try {
			
		if(this.conn==null || this.conn.isClosed())
                   openConnection();
		createTable = new CreateTable(this.conn);
		createTable.doCreateTable("fiku2");
		createTable.closeDB();
		success = true;	
            } catch (Exception e) {
			
		System.out.println("IOError : " + e.getMessage());
                errorString = "Time : " + date.toString() + " - Error Message : " + e.getMessage();
            }
            return success;
        }*/
        
        public String getErrorString(){
        
            return this.errorString;
        }
        public void cleanErrorString(){
            
            this.errorString = "";
        }
}

