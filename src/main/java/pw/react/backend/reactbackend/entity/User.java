package pw.react.backend.reactbackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "is_active")
    private boolean is_active;

    public User(){}

    public User (String login, String first_name, String last_name,Date date_of_birth, boolean is_active) {
       this.login=login;
       this.first_name=first_name;
       this.last_name=last_name;
       this.date_of_birth=date_of_birth;
       this.is_active=is_active;
    }

    public void setUser(String login, String first_name, String last_name, Date date_of_birth, boolean active) {
        setLogin(login);
        setFirstName(first_name);
        setLastName(last_name);
        setDateOfBirth(date_of_birth);
        setIsActive(active);
    }

    public Long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }
    public String getLastName() {
        return last_name;
    }
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
    public Date getDateOfBirth() {
        return date_of_birth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.date_of_birth = dateOfBirth;
    }
    public boolean getIsActive() {
        return is_active;
    }
    public void setIsActive(boolean isActive) {
        this.is_active = isActive;
    }

    public  String toString()
    {
        return  "Id: "+this.getId()+"\n"+
                "login: "+this.getLogin()+"\n"+
                "first_name: "+this.getFirstName()+ "\n"+
                "last_name: "+this.getLastName()+"\n"+
                "date_of_birth: "+this.getDateOfBirth()+"\n"+
                "is_active: "+this.getIsActive();
    }
}