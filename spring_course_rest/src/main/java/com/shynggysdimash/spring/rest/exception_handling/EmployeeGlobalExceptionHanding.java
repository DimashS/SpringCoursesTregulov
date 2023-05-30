package com.shynggysdimash.spring.rest.exception_handling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // может теперь пользоваться любой контроллер
public class EmployeeGlobalExceptionHanding {
    // в параметрах exception, на который должен реагировать сам метод handleexception
    // реагирует на цифры ток
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage()); // message сверху в параметрах, здесь обработка
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    // second Overloaded method for every exception
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage()); // message сверху в параметрах, здесь обработка
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
