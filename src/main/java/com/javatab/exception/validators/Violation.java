package com.javatab.exception.validators;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public record Violation(String fieldName, String message) {
}
