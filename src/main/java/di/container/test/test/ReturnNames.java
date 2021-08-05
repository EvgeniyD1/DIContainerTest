package di.container.test.test;

import di.container.test.myimpl.Inject;
import di.container.test.test.interfaces.FriendsFinder;
import di.container.test.test.interfaces.UserFinder;
import di.container.test.test.model.User;
import di.container.test.test.model.UserFriend;

public class ReturnNames {

    @Inject
    private UserFinder userFinder/* = BeanFactory.getInstance().getBean(UserFinder.class)*/;
    @Inject
    private FriendsFinder friendsFinder/* = BeanFactory.getInstance().getBean(FriendsFinder.class)*/;

    public void returnNames(User user, UserFriend userFriend){
        System.out.println("my name " + userFinder.getUserName(user));
        System.out.println("my friend name " + friendsFinder.getFriendName(userFriend));
    }
}
