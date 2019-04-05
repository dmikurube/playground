package org.tsuque.playground.runner;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;

@RunWith(DynamicSuite.class)
public class DynamicTestRun {
    public static Class<?>[] suite() throws IOException {
        final ClassLoader rootClassLoader = DynamicTestRun.class.getClassLoader();
        final URL[] resourceUrls = new URL[1];
        resourceUrls[0] = rootClassLoader.getResource("suite-classes-tests.jar");
        final URLClassLoader suiteClassLoader = new URLClassLoader(resourceUrls, rootClassLoader);

        final Class<?>[] testClasses = new Class<?>[2];
        try {
            testClasses[0] = suiteClassLoader.loadClass("org.tsuque.playground.suite.Test1");
            testClasses[1] = suiteClassLoader.loadClass("org.tsuque.playground.suite.Test2");
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return testClasses;
    }
}
