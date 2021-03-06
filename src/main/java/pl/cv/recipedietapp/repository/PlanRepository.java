package pl.cv.recipedietapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.cv.recipedietapp.entity.Plan;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query(value = "SELECT plan FROM Plan plan WHERE plan.userId = :userId ORDER BY plan.created DESC")
    List<Plan> findAllUserPLans(@Param("userId") long userId);

    @Query(nativeQuery = true, value = "SELECT * FROM plan WHERE plan.userId = :userId ORDER BY plan.created DESC LIMIT 1")
    Plan findUserLastAddedPlan(@Param("userId") long userId);

}

