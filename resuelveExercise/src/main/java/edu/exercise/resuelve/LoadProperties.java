package edu.exercise.resuelve;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase que lee el archivo de configuracion
 * @author Brahian Velazquez
 * */
public class LoadProperties {
    private static Logger logger = LogManager.getLogger(LoadProperties.class);
    public Properties getPropFile(){
        Properties prop = new Properties();
        try(InputStream input = LoadProperties.class.getClassLoader().getResourceAsStream("application.properties")){
            prop.load(input);
            return  prop;
        } catch (IOException ex){
            logger.debug("Error Al tratar de conseguir el property file ..." + ex.getMessage());
        }
        return prop;
    }
}
