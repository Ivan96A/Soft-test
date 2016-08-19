package soft.test.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import soft.test.post.domain.Post;
import soft.test.post.service.PostService;

import static soft.test.role.Role.ROLE_ADMIN;

import java.util.List;

/**
 * Created by Iwan on 11.08.2016.
 */

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    @Qualifier("postService")
    private PostService postService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured({ROLE_ADMIN})
    public ResponseEntity<Void> save(@RequestBody Post post) {
        postService.savePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
