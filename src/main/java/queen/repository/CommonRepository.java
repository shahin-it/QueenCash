package queen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import queen.models.ModelBase;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonRepository<T extends ModelBase> extends CrudRepository<T, Serializable> {
}
