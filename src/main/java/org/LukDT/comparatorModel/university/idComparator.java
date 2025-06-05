package org.LukDT.comparatorModel.university;

import org.LukDT.model.University;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class idComparator implements Comparator<University> {
    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getId(), u2.getId());
    }
}
