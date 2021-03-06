package edu.exercise.resuelve.restcontroller;


import edu.exercise.resuelve.Services.CalcularSueldo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionHandlerClass {
    private static final Logger logger = LogManager.getLogger(ExceptionHandlerClass .class);

    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception ex){
        logger.error("------ Exception  encontrada: " + ex.getMessage());
        return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
