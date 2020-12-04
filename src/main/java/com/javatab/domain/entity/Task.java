package com.javatab.domain.entity;

import com.javatab.domain.base.DomainBase;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter @Setter
public class Task extends DomainBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "task_text")
    private String task;

    @Column(name = "is_completed")
    private boolean isCompleted;

}
