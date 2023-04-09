package com.agancy.realEstate.repositories;

import com.agancy.realEstate.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

    @Query(value =
            "SELECT a " +
            "FROM Advert a " +
            "WHERE a.isActive=TRUE")
    List<Advert> findAllActiveAdverts();

}
