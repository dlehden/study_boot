package com.mert.repository.shipInfoRepository;

import com.mert.model.shipModel.LinerSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinerScheduleRepository extends JpaRepository<LinerSchedule, Long> {

}
