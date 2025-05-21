package org.LukDT;

public class Main {
    public static void main(String[] args) {
        University niu = new University("1", "Национальный исследовательский университет",
                                        "НИУ", 1996, StudyProfile.LAWYER);
        University idk = new University("2", "Институт деловой карьеры", "ИДК",
                                        1996, StudyProfile.IT);
        University mpu = new University("3", "Московский политехнический университет",
                                        "МПУ", 1865, StudyProfile.TECHNICIAN);
        System.out.println(niu);
        System.out.println(idk);
        System.out.println(mpu);

        Student ivan = new Student("Иван Васильевич Професионалов", mpu.getId(), 1, 4.3f);
        Student vlad = new Student("Владислав Владимирович Адвокатов", niu.getId(), 2, 3.5f);
        Student katya = new Student("Екатерина Дмитриевна Мониторовна", idk.getId(), 4, 4.8f);

        System.out.println(ivan);
        System.out.println(vlad);
        System.out.println(katya);
    }
}
