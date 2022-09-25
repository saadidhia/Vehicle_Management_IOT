package com.deutschland.springconceptreplay.Entity;

import com.deutschland.springconceptreplay.Enum.StatusCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="car", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedEntityGraph(name="car_graph", attributeNodes = @NamedAttributeNode("demands"))
public class Car {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="model")
    private String model;
    private String engine;
    @Column(name="info_system")
    private String infoSystem;
    @Column(name="interior_design")
    private String interiorDesign;
    @Column(name="current_location")
    private String currentLoc;
    private StatusCar statusCar;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<Demand> demands;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;




}
