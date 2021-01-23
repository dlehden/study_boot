package com.mert.repository.shipInfoRepository;

import com.mert.model.shipModel.LinerCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinerCodeRepository extends JpaRepository<LinerCode, Long> {
}
