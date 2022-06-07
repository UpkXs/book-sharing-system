package kz.iitu.itse1903.sugurali.auth;


import java.util.Optional;

public interface UserDao {
    Optional<User> selectApplicationUserByUsername(String username);
}
