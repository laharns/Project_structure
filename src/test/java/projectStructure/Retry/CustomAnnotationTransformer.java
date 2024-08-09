package projectStructure.Retry;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CustomAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Example: Modify the retry analyzer for all tests
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
