package com.redventures.ramengo.admin.repository;

import com.redventures.ramengo.admin.domain.Broth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrothRepository extends JpaRepository<Broth, Long> {
}
