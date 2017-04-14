package mdcms.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="GALLERY")
public class Gallery {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name="TITLE", nullable=false)
    private String title;

    @NotEmpty
    @Column(name="ADDRESS", nullable=false)
    private String address;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate date;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
