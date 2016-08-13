package soft.test.comment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soft.test.comment.domain.Comment;
import soft.test.comment.repository.CommentRepository;
import soft.test.comment.service.CommentService;

import java.util.List;

/**
 * Created by Iwan on 11.08.2016.
 */
@Component("commentService")
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
