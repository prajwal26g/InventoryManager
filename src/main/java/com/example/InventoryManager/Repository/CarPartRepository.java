package com.example.InventoryManager.Repository;

import com.example.InventoryManager.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, String>
{
    @Query("SELECT p from CarPart p WHERE (p.stock - p.reserved) < : threshold")
    List<CarPart> findLowStockParts(@Param("threshold") int threshold);

    /*
    save(S entity): Saves or updates a given entity.
    saveAll(Iterable<S> entities): Saves a collection of entities.
    findById(ID id): Retrieves an entity by its primary key.
    existsById(ID id): Checks if an entity exists with the specified ID.
    findAll(): Returns all instances of the entity type.
    findAllById(Iterable<ID> ids): Returns all entities matching the provided IDs.
    count(): Returns the total number of entities.
    deleteById(ID id): Deletes the entity with the given ID.
    delete(T entity): Deletes a specific entity instance.
    deleteAll(): Deletes all entities.
     */
}
