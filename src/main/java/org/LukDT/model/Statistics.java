package org.LukDT.model;

import org.LukDT.enums.StudyProfile;

public class Statistics {
    private StudyProfile statisticsProfile;
    private float statisticsAvg;
    private int statisticsCountStudents;
    private int statisticsCountUniversity;
    private String statisticsNameUniversity;

    public Statistics() {

    }

    public Statistics(StudyProfile statisticsProfile, float statisticsAvg, int statisticsCountStudents,
                      int statisticsCountUniversity, String statisticsNameUniversity) {
        this.statisticsProfile = statisticsProfile;
        this.statisticsAvg = statisticsAvg;
        this.statisticsCountStudents = statisticsCountStudents;
        this.statisticsCountUniversity = statisticsCountUniversity;
        this.statisticsNameUniversity = statisticsNameUniversity;
    }

    public StudyProfile getStatisticsProfile() {
        return statisticsProfile;
    }

    public void setStatisticsProfile(StudyProfile statisticsProfile) {
        this.statisticsProfile = statisticsProfile;
    }

    public float getStatisticsAvg() {
        return statisticsAvg;
    }

    public void setStatisticsAvg(float statisticsAvg) {
        this.statisticsAvg = statisticsAvg;
    }

    public int getStatisticsCountStudents() {
        return statisticsCountStudents;
    }

    public void setStatisticsCountStudents(int statisticsCountStudents) {
        this.statisticsCountStudents = statisticsCountStudents;
    }

    public int getStatisticsCountUniversity() {
        return statisticsCountUniversity;
    }

    public void setStatisticsCountUniversity(int statisticsCountUniversity) {
        this.statisticsCountUniversity = statisticsCountUniversity;
    }

    public String getStatisticsNameUniversity() {
        return statisticsNameUniversity;
    }

    public void setStatisticsNameUniversity(String statisticsNameUniversity) {
        this.statisticsNameUniversity = statisticsNameUniversity;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "statisticsProfile=" + statisticsProfile +
                ", statisticsAvg=" + statisticsAvg +
                ", statisticsCountStudents=" + statisticsCountStudents +
                ", statisticsCountUniversity=" + statisticsCountUniversity +
                ", statisticsNameUniversity='" + statisticsNameUniversity + '\'' +
                '}';
    }
}
