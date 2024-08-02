package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="Students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Students {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int rollNo;
    private String name;
    private String address;
    //private String sunName;

    @OneToMany(cascade =CascadeType.ALL)
    private Set<Books> ob;

//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}
