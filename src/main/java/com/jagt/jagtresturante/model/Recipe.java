package com.jagt.jagtresturante.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(name = "Recipes")

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(name ="Ingredient")
    private String ingredient;

    @NonNull
    @Column(name ="Measurement")
    private String measurement;

    @NonNull
    @Column(name = "Kitchen Equipment")
    private String kitchenEquipment;

    @NonNull
    @Column(name = "Duration in Minutes")
    private Integer durationInMM;
}
