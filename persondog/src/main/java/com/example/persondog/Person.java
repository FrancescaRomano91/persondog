package com.example.persondog;

import jakarta.persistence.*;

import java.util.ArrayList;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    private String id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    private List<Custody> custodies = new ArrayList<>();

}
