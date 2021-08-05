package di.container.test.test.model;

public class UserFriend {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserFriend(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
