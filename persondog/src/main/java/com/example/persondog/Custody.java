package com.example.persondog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Custody {

        @Id
        private String id;
        private LocalDate date;
        private String contract;
        private double fee;

        @ManyToOne
        @JoinColumn(name = "person_FK")
        @JsonIgnore
        private Person person;

        @ManyToOne
        @JoinColumn(name = "dog_FK")
        @JsonIgnore
        private Dog dog;
    }

