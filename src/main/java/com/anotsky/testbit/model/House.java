package com.anotsky.testbit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "Houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", length = 50, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Apartment> apartments;
}
