package com.raphasantos.BookStoreManager.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timeStamp, Integer status, String message, String error) {
        super(timeStamp, status,message, error);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErrors(String fieldName, String message){
        this.erros.add(new FieldMessage(fieldName,message));
    }
}
