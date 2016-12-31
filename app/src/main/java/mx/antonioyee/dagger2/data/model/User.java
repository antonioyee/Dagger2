package mx.antonioyee.dagger2.data.model;

/**
 * Created by antonioyee on 30/12/16.
 */

public class User {

    private Long id;
    private String name;
    private String address;
    private String createdAt;
    private String updateAt;

    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + id + '\'' +
                ", address='" + id + '\'' +
                ", createdAt='" + id + '\'' +
                ", updateAt='" + id + '\'' +
                "}";
    }

}
