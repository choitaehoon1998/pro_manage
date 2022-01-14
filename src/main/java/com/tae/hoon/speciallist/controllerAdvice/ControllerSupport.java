package com.tae.hoon.speciallist.controllerAdvice;

import com.tae.hoon.speciallist.item.customException.ItemSeqNotProvidedProperlyException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class ControllerSupport {

    @ExceptionHandler({ItemSeqNotProvidedProperlyException.class})
    public ResponseEntity<String> handle(ItemSeqNotProvidedProperlyException e) {
        return new ResponseEntity<>("Check ItemSeq", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> handle(ConstraintViolationException e) {
        log.info("Check Constraint");
        log.info("UniqueKey 또는 제약조건을 확인하세요.");
        return new ResponseEntity<>("Constraint Violation Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handle(NoSuchElementException e){
        return new ResponseEntity<>("요청 한 내용에 대한 결과 없습니다.",HttpStatus.NO_CONTENT);
    }
}
