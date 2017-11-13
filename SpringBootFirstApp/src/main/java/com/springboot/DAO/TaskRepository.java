package com.springboot.DAO;
import com.springboot.model.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by David on 2017-11-09.
 */
public interface TaskRepository extends CrudRepository<Task,Integer> {
}
