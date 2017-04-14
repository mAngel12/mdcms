package mdcms.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="NAVIGATION_MENU")
public class NavigationMenu {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @NotEmpty
    @Column(name="TITLE", nullable=false)
    private String title;

    @NotEmpty
    @Column(name="URL", nullable=false)
    private String url;

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

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
}
