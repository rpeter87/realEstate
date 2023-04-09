package com.agancy.real_estate.repositories;

import com.agancy.real_estate.entities.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

    @Query(value =
                    "SELECT a " +
                    "FROM Advert a " +
                    "WHERE a.isActive=TRUE")
    List<Advert> findAllActiveAdverts();

    @Query(value =
                    "SELECT a " +
                    "FROM Advert a " +
                    "WHERE a.isActive=TRUE AND a.id=:advertId")
    Optional<Advert> findByIdAndActiveAdvert(Long advertId);
}
