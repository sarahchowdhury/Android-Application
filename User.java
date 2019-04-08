package bd.ac.uiu.mcc;

import java.io.Serializable;
import java.util.Collection;

public class User implements Serializable {
    public String name,email,phone,age;
    public int id,image;

    public User(String name, String email, String phone, String age, int id, int image) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.id = id;
        this.image = image;
    }


    public User(String name, String email, String age, String phone, int image) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
