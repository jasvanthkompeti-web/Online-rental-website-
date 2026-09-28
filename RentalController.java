package com.rental.controller;

import com.rental.model.Rental;
import com.rental.model.Product;
import com.rental.repository.RentalRepository;
import com.rental.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin
public class RentalController {
    private final RentalRepository rentals;
    private final ProductRepository products;
    public RentalController(RentalRepository rentals, ProductRepository products){
        this.rentals=rentals; this.products=products;
    }

    @GetMapping public List<Rental> all(){return rentals.findAll();}
    @GetMapping("/customer") public List<Rental> customer(@RequestParam String email){
        return rentals.findByCustomerEmailIgnoreCase(email);
    }

    @PostMapping public Rental book(@RequestBody Rental rental){
        Product p=products.findById(rental.getProductId()).orElseThrow();
        if(!p.isAvailable()) throw new IllegalStateException("Product is not available");
        long days=ChronoUnit.DAYS.between(rental.getStartDate(),rental.getEndDate());
        if(days < 1) throw new IllegalArgumentException("End date must be after start date");
        rental.setDays((int)days);
        rental.setTotalPrice(days*p.getPricePerDay());
        p.setAvailable(false);
        products.save(p);
        return rentals.save(rental);
    }

    @PutMapping("/{id}/cancel") public Rental cancel(@PathVariable Long id){
        Rental r=rentals.findById(id).orElseThrow();
        r.setStatus("CANCELLED");
        products.findById(r.getProductId()).ifPresent(p->{p.setAvailable(true);products.save(p);});
        return rentals.save(r);
    }
}
