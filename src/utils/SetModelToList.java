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
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kain
 */
public class SetModelToList {
    
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
}
