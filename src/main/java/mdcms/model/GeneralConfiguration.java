package mdcms.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="GENERAL_CONFIGURATION")
public class GeneralConfiguration {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @NotEmpty
    @Column(name="WEB_TITLE")
    private String title;

    @NotEmpty
    @Column(name="WEB_DESCRIPTION")
    private String description;

    @NotEmpty
    @Column(name="WEB_KEYWORDS")
    private String keywords;

    @NotEmpty
    @Column(name="WEB_LANGUAGE")
    private String language;

    @NotEmpty
    @Column(name="WEB_FOOTER")
    private String footer;

    @NotEmpty
    @Column(name="WEB_AUTHOR")
    private String author;

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getFooter() {
        return footer;
    }
    public void setFooter(String footer) {
        this.footer = footer;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
