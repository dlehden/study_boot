package com.mert.repository.userInfoRepository;

/**
 * Created by Yasin Mert on 25.02.2017.
 */
import com.mert.model.userModel.Task;
import com.mert.model.userModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mert.model.userModel.UserTask;

import java.util.List;

@Repository("userTaskRepository")
public interface UserTaskRepository extends JpaRepository<UserTask, Integer> {
    List<UserTask> findByTask (Task task);
    List<UserTask> findByUser (User user);
}
