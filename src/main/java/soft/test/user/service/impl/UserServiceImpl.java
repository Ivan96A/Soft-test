package soft.test.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import soft.test.user.domain.CustomUser;
import soft.test.user.repository.UserRepository;
import soft.test.user.service.UserService;
import org.springframework.security.core.userdetails.User;
import java.util.Collections;
import java.util.List;

/**
 * Created by Iwan on 17.08.2016.
 */
@Component("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        CustomUser user = findOneUserByUsername(username);
        if(user == null) {
                throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        } else {
            return createUser(user);
        }

    }

    @Override
    public CustomUser findOneUserByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public List<CustomUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public CustomUser findOneUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void saveUser(CustomUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void singIn(CustomUser user) {
        SecurityContextHolder.getContext()
                .setAuthentication(authenticate(user));
    }

    @Override
    public void editUser(CustomUser user) {
        userRepository.save(user);
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        CustomUser user = findOneUserByUsername(username);

        if(passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.changePassword(user.getPassword(), user.getId());
        } else {
            throw new SecurityException("Wrong old password");
        }
    }

    @Override
    public Authentication authenticate(CustomUser user) {
        return new UsernamePasswordAuthenticationToken(
                createUser(user),
                null,
                Collections.singleton(createAuthority(user))
        );
    }

    @Override
    public User createUser(CustomUser user) {
       return new User(
               user.getUsername(),
               user.getPassword(),
               Collections.singleton(createAuthority(user))
       );
    }

    @Override
    public GrantedAuthority createAuthority(CustomUser customUser) {
        return new SimpleGrantedAuthority(customUser.getRole());
    }
}
