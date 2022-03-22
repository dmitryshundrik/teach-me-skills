package tms.lesson8;

public class DataBase {
    private static User[] users = new User[1000];
    private static int countUsers = 0;

    public static void setUser(User user) {
        users[countUsers] = user;
        countUsers++;
    }

    public static User getUser(String login) {
        for (int i = 0; i < countUsers; i++) {
            if (users[i].getLogin().equalsIgnoreCase(login)) {
                return users[i];
            }
        }
        return null;
    }
}
