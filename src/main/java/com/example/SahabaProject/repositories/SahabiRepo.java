package com.example.SahabaProject.repositories;
import com.example.SahabaProject.models.Sahabi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SahabiRepo extends JpaRepository<Sahabi, Long> {
    @Query("SELECT s FROM Sahabi s WHERE s.name = :name")
    Optional<Sahabi> findByName(@Param("name") String sahabiName);

    @Query("SELECT s FROM Sahabi s WHERE s.nickname = :nickname")
    Optional<Sahabi> findByNickname(@Param("nickname") String sahabiNickname);
}
