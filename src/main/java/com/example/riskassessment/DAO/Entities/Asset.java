package com.example.riskassessment.DAO.Entities;
import com.example.riskassessment.DAO.Enumerations.criticity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Asset implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idAsset;

    String assetDescription;

    @Enumerated(EnumType.STRING)
    criticity confidentialityImpact;

    @Enumerated(EnumType.STRING)
    criticity integrityImpact;

    @Enumerated(EnumType.STRING)
    criticity availabilityImpact;

    @Enumerated(EnumType.STRING)
    criticity assetValue;

    //Parent
    //ASSET + PROJECT ASSOCIATION
    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Project project;

    //Parent
    //ASSET TYPE + ASSET ASSOCIATION
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    AssetType assetType;

    //Child
    //ASSET + RISK ASSOCIATION
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "asset")
    List<Risk> riskList =new ArrayList<>();
}