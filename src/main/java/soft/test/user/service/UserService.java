package soft.test.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import soft.test.user.domain.CustomUser;

import java.util.List;

/**
 * Created by Iwan on 17.08.2016.
 */
public interface UserService {

    UserDetails loadUserByUsername(String username);

    CustomUser findOneUserById(Long id);

    CustomUser findOneUserByUsername(String username);

    List<CustomUser> getAllUsers();

    void saveUser(CustomUser customUser);

    void editUser (CustomUser customUser);

    void singIn(CustomUser customUser);

    void changePassword( String username, String oldPassword, String newPassword);

    Authentication authenticate(CustomUser customUser);

    User createUser(CustomUser customUser);

    GrantedAuthority createAuthority(CustomUser customUser);
}
