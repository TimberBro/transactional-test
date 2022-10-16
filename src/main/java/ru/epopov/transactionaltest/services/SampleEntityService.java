package ru.epopov.transactionaltest.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.epopov.transactionaltest.model.SampleEntity;
import ru.epopov.transactionaltest.repository.SampleEntityRepository;

@Service
public class SampleEntityService {
  private final SampleEntityRepository sampleEntityRepository;

  public SampleEntityService(SampleEntityRepository sampleEntityRepository) {
    this.sampleEntityRepository = sampleEntityRepository;
  }

  @Transactional
  public void changeName(SampleEntity entity) {
    entity.setName("changeName");
    System.out.println();
  }

  @Transactional
  public SampleEntity save(SampleEntity entity) {
    entity.setName("Save method");
    changeName(entity);
    System.out.println();
    return sampleEntityRepository.save(entity);
  }

  @Transactional
  public SampleEntity findById(Long id) {
    System.out.println();
    return sampleEntityRepository.findById(id).orElseThrow();
  }

  public Iterable<SampleEntity> findAll() {
    return sampleEntityRepository.findAll();
  }
}
