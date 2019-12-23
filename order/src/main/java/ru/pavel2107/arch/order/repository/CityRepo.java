package ru.pavel2107.arch.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.order.domain.City;

public interface CityRepo extends JpaRepository<City, Long> {
}
