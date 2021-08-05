package di.container.test.test.interfaces;

import di.container.test.test.model.User;

public class UserFinderImpl implements UserFinder {
    @Override
    public String getUserName(User user) {
        return user.getName();
    }
}
