package com.example.Practice.Exception;

import com.example.Practice.Dto.ErrorStatusDto;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorStatusDto> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.NOT_FOUND);
        errorStatusDto.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorStatusDto.setAndroidErrorCode(1004);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorStatusDto>(errorStatusDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAuthorizationException.class)
    public ResponseEntity<ErrorStatusDto> handleUserAuthorizationException(UserAuthorizationException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.BAD_REQUEST);
        errorStatusDto.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorStatusDto.setAndroidErrorCode(1002);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorStatusDto>(errorStatusDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorStatusDto> handleValidationException(MethodArgumentNotValidException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.BAD_REQUEST);
        errorStatusDto.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorStatusDto.setAndroidErrorCode(1002);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorStatusDto>(errorStatusDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ErrorStatusDto> handleUnexpectedTypeException(UnexpectedTypeException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.BAD_REQUEST);
        errorStatusDto.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorStatusDto.setAndroidErrorCode(1002);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorStatusDto>(errorStatusDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorStatusDto> handleExpiredJwtException(ExpiredJwtException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.UNAUTHORIZED);
        errorStatusDto.setErrorCode(HttpStatus.UNAUTHORIZED.value());
        errorStatusDto.setAndroidErrorCode(1003);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorStatusDto>(errorStatusDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnsupportedJwtException.class)
    public ResponseEntity<ErrorStatusDto> handleUnsupportedJwtException(UnsupportedJwtException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.UNAUTHORIZED);
        errorStatusDto.setErrorCode(HttpStatus.UNAUTHORIZED.value());
        errorStatusDto.setAndroidErrorCode(1003);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorStatusDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ErrorStatusDto> handleMalformedJwtException(MalformedJwtException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.UNAUTHORIZED);
        errorStatusDto.setErrorCode(HttpStatus.UNAUTHORIZED.value());
        errorStatusDto.setAndroidErrorCode(1003);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorStatusDto>(errorStatusDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<ErrorStatusDto> handleSignatureException(SignatureException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.UNAUTHORIZED);
        errorStatusDto.setErrorCode(HttpStatus.UNAUTHORIZED.value());
        errorStatusDto.setAndroidErrorCode(1003);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorStatusDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorStatusDto> handleExceptionException(Exception exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.UNAUTHORIZED);
        errorStatusDto.setErrorCode(HttpStatus.UNAUTHORIZED.value());
        errorStatusDto.setAndroidErrorCode(1003);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorStatusDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorStatusDto> handleUsernameNotFoundException(UserNotFoundException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.BAD_REQUEST);
        errorStatusDto.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorStatusDto.setAndroidErrorCode(1002);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorStatusDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorStatusDto> handleWrongPasswordException(WrongPasswordException exception) {
        ErrorStatusDto errorStatusDto = new ErrorStatusDto();

        errorStatusDto.setTimeStamp(new Date());
        errorStatusDto.setStatusCode(HttpStatus.BAD_REQUEST);
        errorStatusDto.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorStatusDto.setAndroidErrorCode(1002);
        errorStatusDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorStatusDto, HttpStatus.BAD_REQUEST);
    }
}
