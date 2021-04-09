package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    private String username;
    @Column
    private String name;
    @Column
    private String lastName;

    @Column
    private String password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manager() {
    }

    public Manager(String username, String name, String lastName, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
