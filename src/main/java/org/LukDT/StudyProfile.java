package org.LukDT;

public enum StudyProfile {
    LAWYER("Адвокат"), TECHNICIAN("Техник"), DESIGN("Дизайн"),
    SECURITY("Охрана"), IT("Информационные Технологии");
    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String toString() {
        return profileName;
    }
}
