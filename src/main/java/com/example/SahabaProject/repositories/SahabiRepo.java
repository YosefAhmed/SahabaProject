package com.example.SahabaProject.repositories;
import com.example.SahabaProject.models.Sahabi;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SahabiRepo extends Neo4jRepository<Sahabi, Long> {
    @Query("MATCH(s:Sahabi) WHERE s.name = $sahabiName RETURN s;")
    Optional<Sahabi> findByName(String sahabiName);

    @Query("MATCH(s:Sahabi) WHERE s.nickname = $sahabiNickname RETURN s;")
    Optional<Sahabi> findByNickname(String sahabiNickname);

}
