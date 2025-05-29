package org.LukDT.enums;

public enum StudyProfile {
    LAWYER("Адвокат"), TECHNICIAN("Техник"), DESIGN("Дизайн"),
    SECURITY("Охрана"), IT("Информационные Технологии"), PHYSICS("Физика"),
    MEDICINE("Медицина"), LINGUISTICS("Лингвистика"), MATHEMATICS("Математика");
    String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String toString() {
        return profileName;
    }
}
