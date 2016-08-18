package soft.test.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import soft.test.user.domain.CustomUser;
import soft.test.user.service.UserService;
import static soft.test.role.Role.ROLE_USER;

/**
 * Created by Iwan on 18.08.2016.
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST)
    public ResponseEntity<CustomUser> login(@RequestParam("username") String username,
                                            @RequestParam("password") String password) {
        CustomUser user = userService.findOneUserByUsername(username);
        if(passwordEncoder.matches(password, user.getPassword())) {
            userService.singIn(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>((CustomUser) null, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(
            value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> register(@RequestBody CustomUser user) {
        user.setRole(ROLE_USER);
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
