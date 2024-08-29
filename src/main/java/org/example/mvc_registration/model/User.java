package org.example.mvc_registration.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true, nullable = false)
    String name;//колонка будет уникальной если ставить анотацию @Column

    @Column(nullable = false)
    String password;//нельзя сохранить password если не будет name

    @Column(nullable = false)
    String email;

}
