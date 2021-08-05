package di.container.test.test.interfaces;

import di.container.test.test.model.UserFriend;

public class FriendsFinderImpl implements FriendsFinder {
    @Override
    public String getFriendName(UserFriend userFriend) {
        return userFriend.getName() + " (first implementation)";
    }
}
