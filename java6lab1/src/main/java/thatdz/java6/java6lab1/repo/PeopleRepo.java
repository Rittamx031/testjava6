package thatdz.java6.java6lab1.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.java6.java6lab1.entity.People;

public interface PeopleRepo extends JpaRepository<People,UUID> {
    
}
