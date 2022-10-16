package ru.epopov.transactionaltest.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.epopov.transactionaltest.model.SampleEntity;
import ru.epopov.transactionaltest.services.SampleEntityService;

@Component
public class Example1 implements CommandLineRunner {

  private final SampleEntityService service;

  public Example1(SampleEntityService service) {
    this.service = service;
  }

  void initDatabase() {
    if (!service.findAll().iterator().hasNext()) {
      SampleEntity sampleEntity = new SampleEntity();
      sampleEntity.setName("Init name");
      sampleEntity.setId(1L);
      service.save(sampleEntity);
    } else {
      SampleEntity sampleEntity = service.findAll().iterator().next();
      System.out.println();
      service.changeName(sampleEntity);
      service.save(sampleEntity);
    }
  }

  @Override
  public void run(String... args) throws Exception {
    initDatabase();
  }
}
