package com.example.riskassessment.DAO.Entities;
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
public class Scenario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idScenario;

    String scenarioDescription;
    boolean impactsConfidentiality ;
    boolean impactsIntegrity ;
    boolean impactsAvailability ;

    //child
    //RISK + SCENARIO ASSOCIATION
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "scenario")
    List <Risk> riskList=new ArrayList<>();
}
