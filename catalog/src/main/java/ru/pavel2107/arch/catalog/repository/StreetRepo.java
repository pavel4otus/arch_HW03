package ru.pavel2107.arch.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.catalog.domain.Street;

public interface StreetRepo extends JpaRepository<Street, Long> {
}
