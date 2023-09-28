package com.javatab.exception.validators;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationErrorMessage {
    private List<Violation> violations = new ArrayList<>();
}
