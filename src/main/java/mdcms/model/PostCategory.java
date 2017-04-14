package mdcms.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POST_CATEGORY")
public class PostCategory {

    @Id
    @Column(name="category_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int category_id;

    @NotEmpty
    @Column(name="category_name")
    private String category_name;

    public Integer getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }
}