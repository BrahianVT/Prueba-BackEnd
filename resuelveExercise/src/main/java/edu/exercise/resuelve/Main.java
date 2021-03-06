package edu.exercise.resuelve;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicial el programa donde se leer la entrada del archivo Json y donde se guarda el resultado
 * @author Brahian Velazquez
 * */

@SpringBootApplication
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
