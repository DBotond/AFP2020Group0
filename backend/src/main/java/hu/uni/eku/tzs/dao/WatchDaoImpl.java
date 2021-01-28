package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Watch;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import hu.uni.eku.tzs.dao.entity.WatchEntity;

public class WatchDaoImpl implements WatchDao{
    private final WatchRepository repository;

    public WatchDaoImpl(WatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Watch watch) {
        repository.save(WatchEntityModelConverter.model2entity(watch));
    }

    @Override
    public List<Watch> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(WatchEntityModelConverter::entity2model)
                .collect(Collectors.toList());
    }

    @Override
    public void update(int id, Watch newWatch) {
        WatchEntity update = repository.findById(id);
        update.setId(newWatch.getId());
        repository.save(update);
    }

    @Override
    public void delete(int id) {
        WatchEntity result = repository.findById(id);
        repository.delete(result);
    }

    @Override
    public Watch findById(int id) {
        return WatchEntityModelConverter.entity2model(repository.findById(id));
    }


    public static class WatchEntityModelConverter {
        private static Watch entity2model(WatchEntity entity){
            return new Watch(
                    entity.getId(),
                    entity.getBalance()
            );
        }

        public static WatchEntity model2entity(Watch model) {
            return WatchEntity.builder()
                    .id(model.getId())
                    .balance(model.getBalance())
                    .build();
        }
    }
}


