package com.javatab.domain.base;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = 4546097167586314016L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    BaseEntity that = (BaseEntity) o;

    return new EqualsBuilder()
            .append(id, that.id)
            .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
            .append(id)
            .toHashCode();
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
