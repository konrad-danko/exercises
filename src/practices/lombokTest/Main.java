package practices.lombokTest;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
/*    User user = new User(5l, "Marek", "Markowski", 50);
    user.getAddress();
    //user.setId();
    user.setFirstName("asdfvb");
    System.out.println(user);*/

    User user2 = User.builder()
        .lastName("Adam")
        .firstName("Nowak")
        //.address("Warszawa")
        //.id(5L)
        //.age(50)
        .build();
    System.out.println(user2);
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.dat"));
    oos.writeObject(user2);
    oos.close();
    System.out.println(oos);

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.dat"));
    User object = (User)ois.readObject();
    ois.close();
    System.out.println(object);
  }
}
