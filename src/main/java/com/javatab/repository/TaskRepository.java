package com.javatab.repository;

import com.javatab.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nasir on 4/2/16.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
