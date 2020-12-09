package com.javatab.exception.validators;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Violation {
    private final String fieldName;
    private final String message;

}
