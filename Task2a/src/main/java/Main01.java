import entity.User;
import entity.UserDao;

import java.sql.SQLException;

public class Main01 {

    public static void main(String[] args) throws SQLException {
        User user1 = new User();
        user1.setUserName("jan.kowalski");
        user1.setEmail("jan.kowalski@gmail.com");
        user1.setPassword("abcxyz123");

        User user2 = new User();
        user2.setUserName("adam.nowak");
        user2.setEmail("adam.nowak@onet.pl");
        user2.setPassword("321xyzabc");

        UserDao userDao = new UserDao();
        userDao.create(user1);
        userDao.create(user2);

        User toRead = userDao.read(1);
        System.out.println(toRead);

        User nullRead = userDao.read(5);
        System.out.println(nullRead);

        UserDao userUpdate = new UserDao();
        User userToUpdate = userDao.read(1);
        userToUpdate.setUserName("anna.kowalska");
        userToUpdate.setEmail("anna.kowalska34@vp.pl");
        userToUpdate.setPassword("dgdjskds234");
        userDao.update(userToUpdate);

        UserDao userDelete = new UserDao();
        userDao.delete(3);

        UserDao userFind = new UserDao();
        User[] all = userFind.findAll();
        for (User u : all) {
            System.out.println(u);
        }
    }
}
