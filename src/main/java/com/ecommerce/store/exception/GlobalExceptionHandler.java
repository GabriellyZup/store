package com.ecommerce.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de validação: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de : " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
    }
}

//comenta a parte de cima e descomenta a parte de baixo.
// provoca os erros, e as mensagens  ficarão ruins no thunder, mas fica aparecendo gatinhos na pagina.
// http://localhost:8080/cliente
// http://localhost:8080/produto

//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Object handleValidationExceptions(MethodArgumentNotValidException ex) {
//        if (isBrowserRequest()) {
//            return new RedirectView("https://http.cat/400");
//        }
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Object handleConstraintViolationException(ConstraintViolationException ex) {
//        if (isBrowserRequest()) {
//            return new RedirectView("https://http.cat/400");
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de validação: " + ex.getMessage());
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public Object handleIllegalArgumentException(IllegalArgumentException ex) {
//        if (isBrowserRequest()) {
//            return new RedirectView("https://http.cat/404");
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + " não encontrado.");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public Object handleGenericException(Exception ex) {
//        if (isBrowserRequest()) {
//            return new RedirectView("https://http.cat/500");
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
//    }
//
//    private boolean isBrowserRequest() {
//        return true;
//    }
//}
