package tms.servlet.dao;

import java.util.List;

public class OperationValueLIstHandler<T> implements ValueListIterator<T> {

    private final OperationDao operationDao = new OperationDaoImpl();

    private int cursor = 0;

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public List<T> getCurrentElements() {
        return null;
    }

    @Override
    public List<T> getNextElements() {
        return null;
    }

    @Override
    public List<T> getPreviousElements() {
        return null;
    }

    @Override
    public void resetIndex() {

    }
}
