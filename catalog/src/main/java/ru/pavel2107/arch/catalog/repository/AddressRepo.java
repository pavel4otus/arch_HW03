package ru.pavel2107.arch.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.arch.catalog.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
