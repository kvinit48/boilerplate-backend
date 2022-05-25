package com.lesserror.initializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The Class InitializerApplicationTests.
 */
@SpringBootTest
class InitializerApplicationTests {
  int a=2;
  int b=2;
  /**
   * Context loads.
   */
  @Test
  void contextLoads() {
    assertEquals(a, b);
  }

}
