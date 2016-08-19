package soft.test.post.domain;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Iwan on 19.08.2016.
 */

@Entity
@Table(name = "posts")
public class Post implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content")
    private String content;

    public Post() {

    }

    public Post(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
