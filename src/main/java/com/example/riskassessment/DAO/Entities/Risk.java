package com.example.riskassessment.DAO.Entities;
import com.example.riskassessment.DAO.Enumerations.riskLevel;
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
public class Risk implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idRisk;

    float inherentProbability;
    float inherentImpact;
    float inherentRiskScore;

    float realImpact;
    float realProbability;
    float realRiskScore;

    float residualImpact;
    float residualProbability;
    float residualScore;

    @Enumerated(EnumType.STRING)
    riskLevel inherentRiskLevel;
    @Enumerated(EnumType.STRING)
    riskLevel realRiskLevel;
    @Enumerated(EnumType.STRING)
    riskLevel residualRiskLevel;

    //Parent
    // ASSET + RISK ASSOCIATION
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Asset asset;

    //Parent
    // VUL + RISK ASSOCIATION
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    Vulnerability vulnerability;

    //Parent
    // THREAT + RISK ASSOCIATION
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    Threat threat;

    //Parent
    // SCENARIO + RISK ASSOCIATION
    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    Scenario scenario ;

    //parent
    //CONTROL + RISK ASSOCIATION
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(
            name = "risk_control_list",
            joinColumns = @JoinColumn(name = "risk_list_id_risk"),
            inverseJoinColumns = @JoinColumn(name = "control_list_id_control"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"risk_list_id_risk", "control_list_id_control"})
    )
    List <Control> controlList=new ArrayList<Control>();
}