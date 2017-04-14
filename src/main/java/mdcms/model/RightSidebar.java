package mdcms.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="RIGHT_SIDEBAR")
public class RightSidebar {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @NotEmpty
    @Column(name="TITLE", nullable=false)
    private String title;

    @NotEmpty
    @Column(name="CONTENT", nullable=false)
    private String content;

    @NotEmpty
    @Column(name="`ORDER`", nullable=false)
    private String order;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
}
