package fun.krisme.smartbus;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(
        nameInDb = "USER",
        indexes = {
                @Index(value = "name DESC")
        }

)

public class User {
    @Id(autoincrement = true)
    private Long id;

    @Index(name = "username_index",unique = true)
    private String usercode;

    @Property(nameInDb = "userName")
    @NotNull
    private String name;

    @Property(nameInDb = "Password")
    @NotNull
    private String password;

@Generated(hash = 1971918086)
public User(Long id, String usercode, @NotNull String name,
        @NotNull String password) {
    this.id = id;
    this.usercode = usercode;
    this.name = name;
    this.password = password;
}

@Generated(hash = 586692638)
public User() {
}

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getUsercode() {
    return this.usercode;
}

public void setUsercode(String usercode) {
    this.usercode = usercode;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getPassword() {
    return this.password;
}

public void setPassword(String password) {
    this.password = password;
}
}
