package ru.pavel2107.arch.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.basket.domain.Status;

public interface StatusRepo extends JpaRepository<Status, Long> {
}
