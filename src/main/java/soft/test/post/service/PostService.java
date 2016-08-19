package soft.test.post.service;

import soft.test.post.domain.Post;

import java.util.List;

/**
 * Created by Iwan on 19.08.2016.
 */
public interface PostService {

    List<Post> getAllPosts();

    void savePost(Post post);

}
