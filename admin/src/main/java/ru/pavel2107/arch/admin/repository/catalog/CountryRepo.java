package ru.pavel2107.arch.admin.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.admin.domain.catalog.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {
    Country findByCode(String code);
    Country findByName(String name);
}
