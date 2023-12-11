package domain.DAO;

import java.util.List;
import java.util.Optional;

public interface IJPAPersistence<T> {

    T save(T t);

    Optional<T> getById(Long id);

    List<T>getAll();
}