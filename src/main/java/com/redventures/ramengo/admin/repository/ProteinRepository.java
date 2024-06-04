package com.redventures.ramengo.admin.repository;

import com.redventures.ramengo.admin.domain.Protein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProteinRepository extends JpaRepository<Protein, Long> {
}
