package queen.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public abstract class ModelBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
