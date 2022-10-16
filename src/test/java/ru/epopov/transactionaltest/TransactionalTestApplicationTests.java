package ru.epopov.transactionaltest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@SpringBootTest
class TransactionalTestApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  @Transactional
  public void givenTransactional_whenCheckingForActiveTransaction_thenReceiveTrue() {
    assertTrue(TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Test
  public void givenNoTransactional_whenCheckingForActiveTransaction_thenReceiveFalse() {
    assertFalse(TransactionSynchronizationManager.isActualTransactionActive());
  }


}
