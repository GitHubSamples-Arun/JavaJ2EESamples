package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

	List<Player> findByTeamId(long teamId);
}
