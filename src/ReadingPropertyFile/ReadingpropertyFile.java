package ReadingPropertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingpropertyFile {

	public static void main(String[] args) throws IOException {
		
		//location of property file
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"//TestData//config.properties");
		
		//Loading property file
		Properties property = new Properties();
		property.load(fi);
		
		//Reading data from property file
		String app_url = property.getProperty("appurl");
		String user_name = property.getProperty("username");
		String pass = property.getProperty("password");
		String order_id = property.getProperty("orderid");
		String cutomer_id = property.getProperty("customerid");
		
		//Print
		System.out.println(app_url+"\n"+user_name+"\n"+pass+"\n"+order_id+"\n"+cutomer_id);
		
		//Reading all keys from property file
		Set<String> keys = property.stringPropertyNames(); //return type is set of string
		System.out.println("Keys"+keys);
		
		//Set<Object> keys1 = property.keySet(); //return type is set of object
		//System.out.println("Keys1"+keys1);
		
		//Reading all values from property file
		Collection <Object> values = property.values(); //return collection of values
		System.out.println("Values:"+values);
		
		fi.close();
		
		

	}

}
