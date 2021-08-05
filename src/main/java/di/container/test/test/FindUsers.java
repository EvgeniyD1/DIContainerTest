package di.container.test.test;

import di.container.test.myimpl.Inject;
import di.container.test.myimpl.BeanFactory;
import di.container.test.test.model.UserFriend;
import di.container.test.test.model.User;

public class FindUsers {

    @Inject
    private ReturnNames returnNames = BeanFactory.getInstance().getBean(ReturnNames.class);

    public void getNames() {
        User user = new User("Евгений");
        UserFriend userFriend = new UserFriend("Максим");
        returnNames.returnNames(user, userFriend);
    }

}
