package com.solo.library.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    INVALID_MEMBER_STATUS(400, "Invalid member status"),
    BOOK_NOT_FOUND(404, "Book not found"),
    BOOK_EXISTS(409, "Book exists"),
    HISTORY_NOT_FOUND(404, "Loan History not found"),
    INVALID_LOAN_STATUS(400, "Invalid loan status");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
