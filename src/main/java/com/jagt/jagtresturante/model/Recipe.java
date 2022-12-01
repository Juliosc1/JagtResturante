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
    @Column(name ="Ingredients")
    private String ingredients;

    @NonNull
    @Column(name ="Measurement")
    private String measurement;

    @NonNull
    @Column(name = "KitchenEquipment")
    private String kitchenEquipment;

    @NonNull
    @Column(name = "DurationInMinutes")
    private Integer durationInMM;
}
