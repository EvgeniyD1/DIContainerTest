package di.container.test.myimpl;

import di.container.test.test.interfaces.FriendsFinder;
import di.container.test.test.interfaces.FriendsFinderSecondImpl;

import java.util.Map;

public class JavaConfiguration implements Configuration{
    @Override
    public String getPackageToScan() {
        return "di.container.test";
    }

    @Override
    public Map<Class, Class> getInterfaceToImplementation() {
        return Map.of(FriendsFinder.class, FriendsFinderSecondImpl.class);
    }
}
