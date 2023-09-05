package thatdz.java6.java6lab1.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "people")
public class People {
    @Id
    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
    private String ip_address;
    private String avatar;
    private String country;
    private String job;
    private String company;
    private String salary;
    private String username;
    private String password;
    private String gender;
    private String slogan;

    public Double getSalaryNum() {
        double numericalValue = 0;
        if (this.salary.equals("n/a")) {
            numericalValue = 0;
        } else {
            String num = this.getSalary().substring(1, this.getSalary().length() - 1);
            try {
                numericalValue = Double.parseDouble(num);
                if (this.getSalary().endsWith("M")) {
                    numericalValue = numericalValue * 1000000;
                }
                if (this.getSalary().endsWith("B")) {
                    numericalValue = numericalValue * 1000000000;
                }
            } catch (Exception e) {
                System.out.println("Cannot convert double ");
            }
        }
        return numericalValue;
    }
}
// "id": "1513cebf-8efb-411d-9259-4b8e718e962d",
// "first_name": "Langston",
// "last_name": "Thys",
// "email": "lthys0@timesonline.co.uk",
// "gender": "Male",
// "ip_address": "209.43.110.44",
// "avatar": "https://robohash.org/eaquedictaaut.png?size=50x50&set=set1",
// "country": "Brazil",
// "job": "Marketing Assistant",
// "company": "Devpoint",
// "salary": "$7.18M",
// "username": "lthys0",
// "password": "$2a$04$ZxcJHXrdEBsN17awqH8QUeJuubT9.SR7ByExvDJPmZEfOpvxr7bc.",
// "slogan": "reinvent bricks-and-clicks methodologies"