/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import dbServices.DBServiceInvoker;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kain
 */
public class NotUsedSetModelToList {
    
    public static DefaultTableModel getModels(ResultSet resultSet)throws SQLException{
    DBServiceInvoker invoke = new DBServiceInvoker();
    DefaultTableModel model = new DefaultTableModel();
        ResultSetMetaData meta = resultSet.getMetaData();
    int numberOfColumns = meta.getColumnCount();
    while (resultSet.next())
    {
        Object [] rowData = new Object[numberOfColumns];
        for (int i = 0; i < rowData.length; ++i)
        {
            rowData[i] = resultSet.getObject(i+1);
        }
        model.addRow(rowData);
    }

    return model;
    }
    
    public static DefaultTableModel getTable(JTextField textField, JTable model, String names){
        
        DefaultTableModel defaultTable = (DefaultTableModel) model.getModel();
        int id = 0, size = 0;
        List<String> columnList =  new ArrayList<String>();
        List<String> recordList = new ArrayList<String>();
        DBServiceInvoker dbService = new DBServiceInvoker();
	
        if(textField.getText()!=null && !textField.getText().isEmpty())
            id = Integer.parseInt(textField.getText());
      
        try {
                recordList = dbService.invokeSelectWithPreparedStatement(id);
                if(!recordList.isEmpty()){
                    
                    //name = recordList.get(0);
                    //surname = recordList.get(1);
                    
                    if(defaultTable.getRowCount()==1)
                        defaultTable.removeRow(0);
                    defaultTable.addRow(new Object[]{"("+names+")"});
                    
                }else{
                
                   //name = "no record!";
                   //surname = "no record!";
                   if(defaultTable.getRowCount()==1)
                        defaultTable.removeRow(0);
                    defaultTable.addRow(new Object[]{"("+names+")"});
                }
                dbService.cleanErrorString();
	}catch (SQLException sqlex) {
			
		System.out.println("SQL Error : " + sqlex.getMessage());
        }catch (Exception e) {
			
		System.out.println("Error : " + e.getMessage());
        }
        return defaultTable;
    }
    }

