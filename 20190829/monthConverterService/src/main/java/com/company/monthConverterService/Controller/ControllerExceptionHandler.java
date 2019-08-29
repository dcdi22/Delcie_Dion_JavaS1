package com.company.monthConverterService.Controller;

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
@RequestMapping(produces = "aplication/vnd.error+json") // this is our return type
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class}) // now handling this particular exception
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) // we cannot process your entity
    public ResponseEntity<VndErrors> outOfRangeException(IllegalArgumentException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage()); // creating a new error element
        // ^^ will go out with status 422, with small explanation ^^

        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    // throwing back errors ^^

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> motorcycleValidationError(MethodArgumentNotValidException e, WebRequest request) {

        // BindingResult holds the validation result();
        BindingResult result = e.getBindingResult();
        // Validation errors are stored in the FieldError objects
        List<FieldError> fieldErrors = result.getFieldErrors();

        // Translate the FieldErrors to VndErrors
        List<VndErrors.VndError> vndErrorList = new ArrayList<>(); // just an ArrayList not yet translated and added to this
        // new list until after for loop

        for(FieldError fieldError: fieldErrors) {
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());

            vndErrorList.add(vndError);
        }

        // Wrap all the VndError objects in VndError object
        VndErrors vndErrors = new VndErrors(vndErrorList);

        //create and return the ResponseEntity
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    // errors by default do not come as vnderrors so were turning them into vnderrors
}
