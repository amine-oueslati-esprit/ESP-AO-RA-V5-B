package com.example.riskassessment.DAO.Entities;
import com.example.riskassessment.DAO.Enumerations.ControlCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Entity(name="Control")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Control implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idControl;

    String controlDescription;

    boolean exists;

    boolean preventive;
    boolean corrective;
    boolean detective;

    @Enumerated(EnumType.STRING)
    @JsonProperty("ControlCategory")
    ControlCategory controlCategory;

    float conception;

    float performance;

    float efficacite;

    float ponderationSurImpact;

    float ponderationSurProbabilite;

    float valeurReductionImpact;

    float valeurReductionProbabilite;

    // Risk + CONTROL ASSOCIATION
    //child
    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="controlList")
    List <Risk> riskList=new ArrayList<Risk>();
}