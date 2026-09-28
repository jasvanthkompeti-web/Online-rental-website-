package com.rental.repository;
import com.rental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByCustomerEmailIgnoreCase(String email);
}
