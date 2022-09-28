package lab3_52000643.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Manufacture")
public class Manufacture implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;
    private int employee;

//    @OneToMany(mappedBy = "Manufacture",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private List<Phone> phone;
//
//    public List<Phone> getPhone() {
//        return phone;
//    }
//public void setPhone(List<Phone> phone) {
//    this.phone = phone;
//}
    public Manufacture(){}

    public Manufacture(String name, String location, int employee) {
        this.name = name;
        this.location = location;
        this.employee = employee;
    }
    @Override
    public String toString() {
        return "Manufacture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", Employee=" + employee +
                '}';
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        employee = employee;
    }
}
