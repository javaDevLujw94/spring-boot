package top.lujianwei.boot.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.lujianwei.boot.springboot.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
