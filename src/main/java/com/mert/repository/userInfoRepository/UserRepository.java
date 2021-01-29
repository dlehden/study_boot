package com.mert.repository.userInfoRepository;

/**
 * Created by Yasin Mert on 25.02.2017.
 */
import com.mert.model.userModel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mert.model.userModel.User;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
	List<User> findByRole(Role role);
	List<User> findByName(String name);
}
