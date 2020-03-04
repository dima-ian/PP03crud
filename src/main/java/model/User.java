package model;

import javax.persistence.*;

@Entity
@Table(name="usrs")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private byte age;

    @Column(name = "email")
    private String email;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "role")
    private String role;

    public User( ) { }

    public User(long id, String name, String sex, byte age, String email, String ssn, String role) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
        this.role = role;
    }

    public User(String name, String sex, byte age, String email, String ssn, String role) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
        this.role = role;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getRole() {  return role;  }

    public void setRole(String role) {  this.role = role;  }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
