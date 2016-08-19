package soft.test.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.test.post.domain.Post;

/**
 * Created by Iwan on 19.08.2016.
 */
public interface PostRepository extends JpaRepository<Post, Long>{
}
