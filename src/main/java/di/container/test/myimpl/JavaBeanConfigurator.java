package di.container.test.myimpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JavaBeanConfigurator implements BeanConfigurator {

    private static Class[] classes;
    private final Map<Class, Class> interfaceToImplementation;

    public JavaBeanConfigurator(String packageToScan, Map<Class, Class> interfaceToImplementation) {
        this.interfaceToImplementation = new /*Concurrent*/HashMap<>(interfaceToImplementation);
        try {
            classes = ClassFinder.getClasses(packageToScan);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass) {
        return interfaceToImplementation.computeIfAbsent(interfaceClass, clazz -> {
            Set<Class> implementationsClasses = new HashSet<>();
            for (Class aClass : classes) {
                if (interfaceClass.isAssignableFrom(aClass) && !aClass.isInterface()) {
                    implementationsClasses.add(aClass);
                }
            }
            if (implementationsClasses.size() != 1) {
                throw new RuntimeException("0 or more 1 implementations");
            }
            return implementationsClasses.stream().findFirst().get();
        });
    }


}
