package di.container.test.test.interfaces;

import di.container.test.test.model.UserFriend;

public class FriendsFinderSecondImpl implements FriendsFinder{
    @Override
    public String getFriendName(UserFriend userFriend) {
        return userFriend.getName() + " (second implementation)";
    }
}
