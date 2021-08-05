package di.container.test.task.injector;

@FunctionalInterface
public interface Provider<T> {

    T getInstance();
}
