package com.jazda.mapapi;

import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository {

    public EntityToSave save(EntityToSave entityToSave);
}
