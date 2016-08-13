package soft.test.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import soft.test.comment.domain.Comment;
import soft.test.comment.service.CommentService;

import java.util.List;

/**
 * Created by Iwan on 11.08.2016.
 */

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getAll() {
        return commentService.getAllComment();
    }

}
