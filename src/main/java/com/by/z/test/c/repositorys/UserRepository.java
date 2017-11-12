package com.by.z.test.c.repositorys;

import com.by.z.test.c.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户实体持久化
 *
 * @author zwp
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
