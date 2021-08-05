package di.container.test.myimpl;

import java.util.Map;

public interface Configuration {

    String getPackageToScan();

    Map<Class, Class> getInterfaceToImplementation();
}
