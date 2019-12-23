package ru.pavel2107.arch.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.catalog.domain.GoodOnWareHouse;

public interface GoodOnWareHouseRepo extends JpaRepository<GoodOnWareHouse, Long> {
}
