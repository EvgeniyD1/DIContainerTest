package di.container.test.task.injector;

import di.container.test.myimpl.ClassFinder;

import java.io.IOException;

public class InjectorImpl implements Injector {

    @Override
    public <T> Provider<T> getProvider(Class<T> type) {
//        Class[] classes = getClasses("elinext.test");
//        Set<Class> implementationsClasses = new HashSet<>();
//        for (Class aClass : classes) {
//            if (type.isInstance(aClass)){
//                implementationsClasses.add(aClass);
//            }
//        }
//        if (implementationsClasses.size()!=1){
//            throw new RuntimeException("0 or more 1 implementations");
//        }
//        return implementationsClasses.stream().findFirst().get();
        return null;
    }

    @Override
    public <T> void bind(Class<T> intf, Class<? extends T> impl) {

    }

    @Override
    public <T> void bindSingleton(Class<T> intf, Class<? extends T> impl) {

    }

    private static Class[] getClasses(String packageName){
        try {
            return ClassFinder.getClasses(packageName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
