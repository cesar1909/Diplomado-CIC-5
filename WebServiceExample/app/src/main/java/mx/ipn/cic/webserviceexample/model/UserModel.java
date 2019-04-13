package mx.ipn.cic.webserviceexample.model;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String id;

    private String name;

    private String lastname;

    private Integer age;

    private String mainAddress;

    public UserModel() {
        super();

    }

    public UserModel(String id, String name, String lastname, Integer age, String mainAddress) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mainAddress = mainAddress;
    }

    public UserModel(String name, String lastname, Integer age, String mainAddress) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mainAddress = mainAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    @Override
    public String toString() {
        return String.format("UserModel [id=%s, name=%s, lastname=%s, age=%s, mainAddress=%s]", id, name, lastname, age,
                mainAddress);
    }

}
