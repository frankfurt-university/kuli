package utils;

import java.util.HashMap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import java.util.Map;
import java.util.Iterator;
/**
 *
 * @author NET
 */
public class XMLOperations {
    
    private String xmlPath = "";
    private Map<String, String> elements = null;
    
    public Document parse() throws DocumentException {
        
        SAXReader reader = new SAXReader();
        Document document = reader.read(xmlPath);
        return document;
    }
    
    public void runProcess() {
        
        try {
            Map<String, String> credentials = new HashMap<String, String>();
            Document document = parse();
            Element SERVERCONFIG = document.getRootElement();
 
            for (Iterator i1 = SERVERCONFIG.elementIterator("CREDENTIALS"); i1.hasNext();) {
                
                Element SERVER = (Element) i1.next();
                if(SERVER.attributeValue("ENABLED").equals("Y")) {
                        
                        System.out.println("------------------------------------------------");
                        System.out.println("SERVER HOST--> " + SERVER.elementText("HOST"));
                        credentials.put("host", SERVER.elementText("HOST"));
                        System.out.println("URLPREFIX  --> " + SERVER.elementText("URLPREFIX"));
                        credentials.put("url", SERVER.elementText("URLPREFIX"));
                        System.out.println("USERNAME   --> " + SERVER.elementText("USER"));
                        credentials.put("user", SERVER.elementText("USER"));
                        System.out.println("PASSW0RD   --> " + SERVER.elementText("PASS"));
                        credentials.put("pass", SERVER.elementText("PASS"));
                        System.out.println("DBNAME     --> " + SERVER.elementText("DBNAME"));
                        credentials.put("db", SERVER.elementText("DBNAME"));
                        System.out.println("DRIVER     --> " + SERVER.elementText("DRIVER"));
                        credentials.put("driver", SERVER.elementText("DRIVER"));
                        System.out.println("PORT       --> " + SERVER.elementText("PORT"));
                        credentials.put("port", SERVER.elementText("PORT"));
                        System.out.println("TYPE       --> " + SERVER.attributeValue("TYPE"));
                        System.out.println("------------------------------------------------");
                }
                
            }
            setElements(credentials);
        } catch (Exception e) {
            
            System.out.println("Error : " + e.getMessage());
        }
    }
    public String getXmlPath(){
    
        return this.xmlPath;
    }
    public void setXmlPath(String path){
    
        this.xmlPath = path;
    }
    public Map<String, String> getElements(){
    
        return this.elements; 
    }
    public void setElements(Map<String, String> elements){
    
        this.elements = elements;
    }
}
