package practices.lombokTest;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/*@Getter
@Setter
@ToString
@RequiredArgsConstructor*/
@Data
@Builder
//@Accessors(fluent = true)
public class User implements Serializable {

  private @Setter(AccessLevel.PRIVATE) Long id; // will be set when persisting
  private String firstName;
  private String lastName;
  private String address;
  private int age;

/*  public User(Long id, String firstName, String lastName, int age) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }*/
}
