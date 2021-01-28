package hu.uni.eku.tzs.dao;
import hu.uni.eku.tzs.model.Watch;
import java.util.Collection;

public interface WatchDao {

    void create(Watch watch);

    Collection<Watch> readAll();

    void update(int id, Watch updated);

    void delete(int id);

    Watch findById (int id);
}

