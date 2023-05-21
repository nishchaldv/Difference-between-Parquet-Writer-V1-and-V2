package com.waitingforcode.model;

import avro.shaded.com.google.common.collect.Lists;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ThreadLocalRandom;
import java.time.Instant;

public class WorkingCitizenCreator {
    public static WorkingCitizen getSampleWorkingCitizen(Civilities civilities) {
        int randomMarker = ThreadLocalRandom.current().nextInt(10000);
        return getSampleWorkingCitizen(civilities, randomMarker);
    }
    public static WorkingCitizen getSampleWorkingCitizen(Civilities civilities, int randomMarker) {
        WorkingCitizen workingCitizen = new WorkingCitizen();
        workingCitizen.setCivility(civilities);
        workingCitizen.setCreditRating((double)randomMarker);
        workingCitizen.setCreditRatingInFloat((float)randomMarker);
        workingCitizen.setFirstName("FirstName"+randomMarker);
        workingCitizen.setLastName("LastName"+randomMarker);
        workingCitizen.setAge(randomMarker);
        workingCitizen.setParent(randomMarker%2 == 0);
        workingCitizen.setProfessionalSkills(Lists.newArrayList("programmer"+randomMarker, "IT director"));
        workingCitizen.setProfessionsPerYear(ImmutableMap.of("199"+randomMarker, "programmer", "199"+randomMarker+1,
                "software engineer"));
        workingCitizen.setTimestamp(System.nanoTime());
        return workingCitizen;
    }
}