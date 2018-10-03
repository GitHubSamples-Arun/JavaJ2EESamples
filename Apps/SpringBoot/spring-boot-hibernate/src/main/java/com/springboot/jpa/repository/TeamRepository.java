package com.springboot.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

	Team findByPlayers(long playerId);
}
