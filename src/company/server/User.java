package company.server;

import javax.persistence.*;
import java.util.Random;

/**
 * Databas objekt som används av Account för att skilja användardata mot account data
 */
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "username", nullable = false)
    String username;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "admin", nullable = false)
    Boolean admin;

    public User (){
    }
    public User (String s){
        this(Integer.toString(new Random().nextInt()+4), s, "", false);
    }
    //Bara åtkomlig i paketet eftersom vi använder username för att säkerhetsställa användare
    protected User (String username, String name, String password, Boolean admin){
        this.username = username;
        this.name = name;
        this.password = password;
        this.admin = admin;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
