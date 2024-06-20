package com.lattice.exceptions;

import com.lattice.exceptions.custom.DoctorNotFoundException;
import com.lattice.exceptions.custom.PatientNotFoundException;
import com.lattice.exceptions.custom.SymptomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralizedExceptionHandler
{
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> exceptionOcurred()
    {
        return new ResponseEntity<>("Patient not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SymptomNotFoundException.class)
    public ResponseEntity<String> exceptionOcurredd()
    {
        return new ResponseEntity<>("Symptom not available.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<String> exceptionOcurreddd()
    {
        return new ResponseEntity<>("Doctor not available.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionOccurredddd()
    {
        return new ResponseEntity<>("OOPS! Unknown thing happened.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
