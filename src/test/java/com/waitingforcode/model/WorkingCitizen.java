package com.waitingforcode.model;

import com.google.common.base.MoreObjects;
import org.apache.avro.Schema;

import java.util.List;
import java.util.Map;

import java.time.Instant;


public class WorkingCitizen {

    public static final Schema AVRO_SCHEMA = new Schema.Parser().parse("{\"type\":\"record\", \"name\":\"WorkingCitizen\"," +
            "\"namespace\":\"com.waitingforcode.model\", \"fields\":[" +
            "{\"name\":\"professionalSkills\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}," +
            "{\"name\":\"professionsPerYear\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}," +
            "{\"name\":\"civility\",\"type\":{\"type\":\"enum\",\"name\":\"Civilities\"," +
            "\"symbols\":[\"MR\",\"MS\",\"MISS\",\"MRS\"]}}," +
            "{\"name\":\"firstName\",\"type\":\"string\"}," +
            "{\"name\":\"lastName\",\"type\":\"string\"}," +
            "{\"name\":\"age\",\"type\":\"int\"}," +
            "{\"name\":\"creditRating\",\"type\":\"double\"}," +
            "{\"name\":\"creditRatingInFloat\",\"type\":\"float\"}," +
            "{\"name\":\"isParent\",\"type\":\"boolean\"}," +
            "{\"name\":\"timestamp\", \"type\": { \"type\":\"long\", \"logicalType\":\"timestamp-nanos\"}}" +
            "]}");


    private Civilities civility;

    private String firstName;

    private String lastName;

    private int age;

    private Double creditRating;

    private Float creditRatingInFloat;

    private Boolean isParent;

    private List<String> professionalSkills;

    private Map<String, String> professionsPerYear;

    private long timestamp;




    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Civilities getCivility() {
        return civility;
    }

    public void setCivility(Civilities civility) {
        this.civility = civility;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age){this.age = age;}

    public Double getCreditRating() {
        return creditRating;
    }


    public void setCreditRating(Double creditRating) {
        this.creditRating = creditRating;
    }

    public Float getCreditRatingInFloat() {
        return creditRatingInFloat;
    }

    public void setCreditRatingInFloat(Float creditRatingInFloat) {
        this.creditRatingInFloat = creditRatingInFloat;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public List<String> getProfessionalSkills() {
        return professionalSkills;
    }

    public void setProfessionalSkills(List<String> professionalSkills) {
        this.professionalSkills = professionalSkills;
    }

    public Map<String, String> getProfessionsPerYear() {
        return professionsPerYear;
    }

    public void setProfessionsPerYear(Map<String, String> professionsPerYear) {
        this.professionsPerYear = professionsPerYear;
    }



    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("civility", civility).add("firstName", firstName)
                .add("lastName", lastName).add("age", age).add("creditRating", creditRating).add("creditRatingInFloat", creditRatingInFloat).add("isParent", isParent)
                .add("professionalSkills", professionalSkills).add("professionsPerYear", professionsPerYear).toString();
    }

}