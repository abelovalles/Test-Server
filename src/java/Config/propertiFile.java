/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author abelricardo
 */
public class propertiFile {
    public String dbUrl;
    public String dbSchema;
    public String usuario;
    public String contraseña;
    
    public propertiFile(){
        Properties prop = new Properties();
	InputStream input = null;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		input = classLoader.getResourceAsStream("Config/config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
		dbUrl=prop.getProperty("dbURL");
		dbSchema=prop.getProperty("schema");
		usuario=prop.getProperty("usuario");
                contraseña=prop.getProperty("contraseña");

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    }
    
}
