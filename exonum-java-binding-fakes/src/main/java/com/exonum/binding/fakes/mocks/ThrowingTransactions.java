/*
 * Copyright 2018 The Exonum Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.exonum.binding.fakes.mocks;

import static org.mockito.Mockito.mock;

import com.exonum.binding.messages.Transaction;
import java.lang.reflect.Constructor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * A factory of throwing transaction mocks.
 */
public final class ThrowingTransactions {

  /**
   * Creates a mock of Transaction that throws an exception of the given type
   * in all of its methods.
   *
   * @param exceptionType a type of exception to throw
   * @throws IllegalArgumentException if exception type is un-instantiable (e.g, abstract)
   */
  public static Transaction createThrowing(Class<? extends Throwable> exceptionType) {
    Answer throwByDefault = new AlwaysThrowingAnswer(exceptionType);
    return mock(Transaction.class, throwByDefault);
  }

  private static class AlwaysThrowingAnswer implements Answer {

    private final Class<? extends Throwable> exceptionType;

    AlwaysThrowingAnswer(Class<? extends Throwable> exceptionType) {
      checkCanInstantiate(exceptionType);
      this.exceptionType = exceptionType;
    }

    private void checkCanInstantiate(Class<? extends Throwable> exceptionType) {
      try {
        // Try to create an exception of the given type, discard the instance if successful.
        Constructor constructor = exceptionType.getDeclaredConstructor();
        constructor.newInstance();
      } catch (Exception e) {
        throw new IllegalArgumentException("Un-instantiable exception type: " + exceptionType, e);
      }
    }

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
      throw exceptionType.getDeclaredConstructor().newInstance();
    }
  }

  private ThrowingTransactions() {}
}
