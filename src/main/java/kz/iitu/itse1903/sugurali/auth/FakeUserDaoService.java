package kz.iitu.itse1903.sugurali.auth;

import com.google.common.collect.Lists;
import kz.iitu.itse1903.sugurali.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeUserDaoService implements UserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

    private List<User> getApplicationUsers() {
        List<User> users = Lists.newArrayList(
                new User(
                        UserRole.ADMIN.getGrantedAuthority(),
                        passwordEncoder.encode("aro"),
                        "aro",
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        UserRole.USER.getGrantedAuthority(),
                        passwordEncoder.encode("aba"),
                        "aba",
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        UserRole.USER.getGrantedAuthority(),
                        passwordEncoder.encode("baha"),
                        "baha",
                        true,
                        true,
                        true,
                        true
                )
        );

        return users;
    }
}

