package com.optum.runwithitapp.Goals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class GoalsServiceImplTest {

    @Autowired
    private GoalsService goalsService;

    @Test
    void getAllUserGoals() {
        List<Goals> allUserGoals = goalsService.getAllUserGoals();
        int sizeBeforeAdditionEntries = allUserGoals.size();

        Goals testGoals = new Goals();
        testGoals.setGoalName("Goal Name Test");
        testGoals.setStatus("Inactive");
        testGoals.setExerciseName("Swimming");
        testGoals.setExerciseType("Cardio");
        testGoals.setSets(4);
        testGoals.setReps(5);
        testGoals.setWeightAmount(42);
        testGoals.setDuration(72);
        testGoals.setGoalSet(new Date(2022, 1, 3));
        testGoals.setGoalCompleted(new Date(1999, 10, 20));
        goalsService.saveUserGoals(testGoals);
        int sizeAfterAddingEntries = goalsService.getAllUserGoals().size();

        Assertions.assertThat(sizeAfterAddingEntries).isEqualTo(sizeBeforeAdditionEntries + 1);
        Assertions.assertThat(allUserGoals.contains(testGoals));

    }

    @Test
    void saveUserGoals() {
    }

    @Test
    void getUserGoalsById() {
        List<Goals> allUserGoals = goalsService.getAllUserGoals();
        Goals testGoalId = allUserGoals.get(0);
        if(testGoalId != null){
            Goals goalsById2 = goalsService.getUserGoalsById(testGoalId.getId());
            Assertions.assertThat(testGoalId).isEqualTo(goalsById2);
        }
    }

    @Test
    void deleteUserGoalsById() {
    }
}