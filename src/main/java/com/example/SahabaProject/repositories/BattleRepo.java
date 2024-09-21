package com.example.SahabaProject.repositories;

import com.example.SahabaProject.models.Battle;
import com.example.SahabaProject.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BattleRepo extends JpaRepository<Battle, String> {

//    @Query("SELECT b FROM Battle b WHERE b.name = :name")
//    Optional<Battle> findBattleByName(@Param("name") String name);

    @Query("SELECT b FROM Battle b WHERE b.enemy = :enemy")
    Optional<Battle> findBattleByEnemy(@Param("enemy") String enemy);

    @Query("SELECT b FROM Battle b WHERE b.dateOfBattle = :dateOfBattle")
    Optional<Battle> findBattleByDate(@Param("dateOfBattle") java.util.Date dateOfBattle);

    @Query("SELECT b FROM Battle b WHERE b.location = :location")
    List<Battle> findByLocation(@Param("location") Place location);

    @Query("SELECT b FROM Battle b WHERE b.result = :result")
    List<Battle> findByResult(@Param("result") String result);
}
