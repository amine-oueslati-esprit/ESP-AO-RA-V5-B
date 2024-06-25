package com.example.riskassessment.DAO.Repositories;
import com.example.riskassessment.DAO.Entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface riskRepo extends JpaRepository<Risk, Long> {
    @Query("SELECT r FROM Risk r LEFT JOIN FETCH r.controlList")
    List<Risk> findAllWithControls();

    boolean existsByAsset_IdAssetAndVulnerability_IdVulnerabilityAndThreat_IdThreatAndScenario_IdScenario(Long assetId, Long vulnerabilityId, Long threatId, Long scenarioId);


    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Risk r WHERE r.asset.idAsset = :assetId AND r.vulnerability.idVulnerability = :vulnerabilityId AND r.threat.idThreat = :threatId AND r.scenario.idScenario = :scenarioId")
    boolean duplicatesCheck(@Param("assetId") Long assetId, @Param("vulnerabilityId") Long vulnerabilityId, @Param("threatId") Long threatId, @Param("scenarioId") Long scenarioId);
}