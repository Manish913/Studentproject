package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Books {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int bookId;
    private String bookName;

    @ManyToOne
    @JoinColumn(name="student_id")
    Students ob;
}
