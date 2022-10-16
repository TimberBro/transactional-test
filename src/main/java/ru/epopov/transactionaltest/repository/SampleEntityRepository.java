package ru.epopov.transactionaltest.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.epopov.transactionaltest.model.SampleEntity;

@Repository
public interface SampleEntityRepository extends  CrudRepository<SampleEntity, Long> {

}
