package soft.test.comment.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Iwan on 11.08.2016.
 */

@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    public Comment() {

    }

    public Comment(String content) {
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
