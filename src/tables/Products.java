/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tables;
import dbServices.DBServiceInvoker;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**creates a model for Products table from DB
 *
 * @author Juraj
 */
public class Products extends DefaultTableModel{
    
    /** c-tor fills this with data from DB
    *   leider läuft es nicht wie gewollt
    */
    public Products(){
        super();
        //this.columnIdentifiers = new Vector({"Product ID:",})
    
    
    
        try { //this. = Guis.Product.getTableModel;
            DBServiceInvoker invoke = new DBServiceInvoker();

            List<String> cp = invoke.invokeSelect("product", "");
            Iterator<String> i = cp.iterator();
            while (i.hasNext()) {
                String[] subString = i.next().split(Pattern.quote(" "));

                String idProduct = subString[0];
                String vendor = subString[1];
                String product = subString[2];
                String version = subString[3];
                String sysReq = subString[4];
                String info = subString[5];
                this.addRow(new Object[]{idProduct, vendor, product, version, sysReq, info});
            }
            invoke.cleanErrorString();

        } catch (SQLException sqlex) {

            System.out.println("SQL Error : " + sqlex.getMessage());
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
