package ru.pavel2107.arch.admin.repository.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pavel2107.arch.admin.domain.catalog.Address;


public interface AddressRepo extends JpaRepository<Address, Long> {
}
