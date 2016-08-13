package soft.test.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.test.comment.domain.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Iwan on 11.08.2016.
 */

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
