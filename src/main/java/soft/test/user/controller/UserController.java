package soft.test.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import soft.test.user.domain.CustomUser;
import soft.test.user.service.UserService;

import java.security.Principal;
import java.util.List;

import static soft.test.role.Role.ROLE_ADMIN;
import static soft.test.role.Role.ROLE_USER;



/**
 * Created by Iwan on 18.08.2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("userService")
    private  UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @Secured(value = {ROLE_ADMIN})
    public ResponseEntity<List<CustomUser>> getAll() {
        return new ResponseEntity<List<CustomUser>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> singUp(@RequestBody CustomUser user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/change-password",
            method = RequestMethod.POST)
    @Secured(value = {ROLE_ADMIN, ROLE_USER})
    public ResponseEntity<Void> changePassword(Principal principal,
                                               @RequestParam("oldPassword") String oldPassword,
                                               @RequestParam("newPassword") String newPassword) {
        userService.changePassword(principal.getName(), oldPassword, newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "/current",
            method = RequestMethod.GET)
    @Secured(value = {ROLE_ADMIN, ROLE_USER})
    public ResponseEntity<CustomUser> getCurrentUser(Principal principal) {
        CustomUser user = userService.findOneUserByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
