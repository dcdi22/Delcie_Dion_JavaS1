package com.company.restCalculatorService.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.*;
import org.springframework.web.context.request.WebRequest;

import javax.naming.Binding;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors.VndError> numberFormatException  (NumberFormatException exception, WebRequest request) {
        VndErrors.VndError clientErr = new VndErrors.VndError(exception.toString(), "Not a number, try again.");
        return new ResponseEntity<VndErrors.VndError>(clientErr, HttpStatus.BAD_REQUEST);
    }

}
