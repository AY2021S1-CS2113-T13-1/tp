package seedu.duke.util;

import java.util.Comparator;
import java.time.LocalDate;

public class DateComparator implements Comparator<LocalDate> {

    @Override
    public int compare(LocalDate o1, LocalDate o2) {
        return o1.compareTo(o2);
    }
}