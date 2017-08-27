package queen.repository;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface QueenRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
}
