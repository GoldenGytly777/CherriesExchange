package Services;

import java.util.List;

public interface ServiceTemplate<U,T> {
    public void  deleteObjectById(T id);
    public U save(U object);
    public List<U> findAll();
    public U findById(T id);

}
