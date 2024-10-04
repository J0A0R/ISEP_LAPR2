package app.domain.model;

import java.util.Comparator;

public class OrderUserEntryList implements Comparator<UserEntry> {
    @Override
    public int compare(UserEntry o1, UserEntry o2) {
        return (-1)*o2.getLastEntry().compareTo(o1.getLastEntry());
    }
}
