package bookstore;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDAO {
    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
        serializeToFile(userList);
    }

    private void serializeToFile(List<User> userList) {
        String userDataPath = this.getClass().getClassLoader().getResource("usersData").getFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(userDataPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private List<User>initializeFromFile(){
        String userDataPath = this.getClass().getClassLoader().getResource("usersData").getFile();
        try (FileInputStream fileInputStream = new FileInputStream(userDataPath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

           return  (List<User>)objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();;
        }
        return Arrays.asList();
    }
}

