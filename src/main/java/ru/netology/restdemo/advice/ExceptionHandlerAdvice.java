package ru.netology.restdemo.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.restdemo.exception.InvalidCredentials;
import ru.netology.restdemo.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> emptyUserHandler(InvalidCredentials e) {
        return new ResponseEntity<>("Отсутствует поле user или password", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        return new ResponseEntity<>("Отсутствует такой пользователь", HttpStatus.UNAUTHORIZED);
    }
}