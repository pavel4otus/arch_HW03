package ru.pavel2107.arch.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.order.domain.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findByCode(String code);
    Country findByName(String name);
}
