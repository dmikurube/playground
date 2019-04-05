package org.tsuque.playground.runner;

import java.io.IOException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

public class DynamicSuite extends Suite {
    public DynamicSuite(final Class<?> setupClass) throws InitializationError, IOException {
        super(setupClass, DynamicTestRun.suite());
    }
}
