package di.container.test.myimpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanFactory {

    private static final BeanFactory BEAN_FACTORY = new BeanFactory();
    private final Configuration configuration;
    private final BeanConfigurator beanConfigurator;

    private BeanFactory() {
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(), configuration.getInterfaceToImplementation());
    }

    public static BeanFactory getInstance() {
        return BEAN_FACTORY;
    }

    public <T> T getBean(Class<T> clazz){
        Class<? extends T> implementationClass = clazz;
        if (implementationClass.isInterface()){
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }
        try {
            T bean = implementationClass.getDeclaredConstructor().newInstance();
            List<Field> fields = Arrays.stream(implementationClass.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Inject.class)).collect(Collectors.toList());
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(bean, BEAN_FACTORY.getBean(field.getType()));
            }
            return bean;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
