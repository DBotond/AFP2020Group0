package hu.uni.eku.tzs.service;
import hu.uni.eku.tzs.dao.WatchDao;
import hu.uni.eku.tzs.model.Watch;
import hu.uni.eku.tzs.service.exceptions.WatchAlreadyExistException;
import hu.uni.eku.tzs.service.exceptions.WatchNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class WatchServiceImpl implements WatchService{

    private final WatchDao dao;
    @Override
    public void record(Watch watch) throws WatchAlreadyExistException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch(cn ->
                        cn.getBalance() == watch.getBalance());
        if (isAlreadyRecorded) {
            log.info("Watch {} is already recorded!", watch);
            throw new WatchAlreadyExistException(String.format("Watch (%s) already exists!", watch.toString()));
        }
        dao.create(watch);
    }

    @Override
    public Collection<Watch> readAll() {
        return dao.readAll();
    }

    @Override
    public void update(int id, Watch updated) throws WatchNotFoundException {
        dao.update(id,updated);
    }

    @Override
    public void delete(int id) throws WatchNotFoundException {
        dao.delete(id);
    }
}
