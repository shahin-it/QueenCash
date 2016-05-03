package queen.models.admin;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="blog_admin")
public class BlogAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3, max = 80)
    private String email;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public BlogAdmin() { }

    public BlogAdmin(long id) { 
      this.id = id;
    }

    public BlogAdmin(String email, String name) {
      this.email = email;
      this.name = name;
    }

    public long getId() {
      return id;
    }

    public void setId(long value) {
      this.id = value;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String value) {
      this.email = value;
    }

    public String getName() {
      return name;
    }

    public void setName(String value) {
      this.name = value;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
  
}
