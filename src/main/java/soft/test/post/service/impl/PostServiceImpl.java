package soft.test.post.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import soft.test.post.domain.Post;
import soft.test.post.repository.PostRepository;
import soft.test.post.service.PostService;

import java.util.List;

/**
 * Created by Iwan on 19.08.2016.
 */
@Component("postService")
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void savePost(Post post) {postRepository.save(post);
    }
}
