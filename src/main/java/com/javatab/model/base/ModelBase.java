package com.javatab.model.base;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class ModelBase implements Serializable {

  private static final long serialVersionUID = -2404541350049677910L;

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
