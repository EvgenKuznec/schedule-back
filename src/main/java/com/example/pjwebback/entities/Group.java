package com.example.pjwebback.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name="groups")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Group  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "department_id")
    @ManyToOne
    @NotNull(message = "необхідно обрати")
    private Department department;

    @NotBlank(message ="необхідна")
    @Pattern(regexp = "(^$)|[а-яА-ЯїієЄІЇa-zA-Z\\-\\d '']+", message = "повинна містити лише цифри, українські та англійські літери")
    private String name;

    @Min(value = 1, message = "повинен бути від 1 до 6")
    @Max(value = 6, message = "повинен бути від 1 до 6")
    private Integer course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Group group = (Group) o;
        return id != null && Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
