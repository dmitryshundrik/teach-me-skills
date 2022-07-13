package tms.servlet.dao;

import java.util.List;

public interface ValueListIterator<T> {

    int getSize();
    List<T> getCurrentElements();
    List<T> getNextElements();
    List<T> getPreviousElements();
    void resetIndex();

}
