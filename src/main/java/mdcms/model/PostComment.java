package mdcms.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="POST_COMMENTS")
public class PostComment {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate date;

    @NotEmpty
    @Column(name="AUTHOR")
    private String author;

    @NotEmpty
    @Column(name="CONTENT")
    private String content;

    @NotNull
    @OneToOne
    @JoinColumn(name="POST_ID")
    private Post post;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }

}