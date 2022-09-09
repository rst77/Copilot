package com.r13a.copilot.model;

import java.io.Serializable;
import java.util.Date;

public class RacePlanning implements Serializable {

    private String  racePlanningId;
    private Date    creationDate;
    private String  description;

    private Date    raceDate;
    private Integer totalDistance;
    private Integer maxDuration;
    private Integer desireDuration;
    private Integer minSpeedAvg;
    private Integer desiredSpeedAvg;

    public RacePlanning(String racePlanningId, Date creationDate, String description) {
        this.racePlanningId = racePlanningId;
        this.creationDate = creationDate;
        this.description = description;
    }

    public String getRacePlanningId() {
        return racePlanningId;
    }

    public void setRacePlanningId(String racePlanningId) {
        this.racePlanningId = racePlanningId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Integer getDesireDuration() {
        return desireDuration;
    }

    public void setDesireDuration(Integer desireDuration) {
        this.desireDuration = desireDuration;
    }

    public Integer getMinSpeedAvg() {
        return minSpeedAvg;
    }

    public void setMinSpeedAvg(Integer minSpeedAvg) {
        this.minSpeedAvg = minSpeedAvg;
    }

    public Integer getDesiredSpeedAvg() {
        return desiredSpeedAvg;
    }

    public void setDesiredSpeedAvg(Integer desiredSpeedAvg) {
        this.desiredSpeedAvg = desiredSpeedAvg;
    }
}
