package com.rental;

import com.rental.model.Product;
import com.rental.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentalApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Product("MacBook Air M2", "Apple", "Laptop",
                        "13-inch MacBook Air M2, suitable for study and work.", 999, 5000,
                        "https://images.rawpixel.com/image_social_landscape/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA4L2hpcHBvdW5pY29ybl9waG90b2dyYXBoeV9vZl9sYXB0b3Bfc2ltcGxlX2Flc3RoZXRpY19pc29sYXRlZF9pc183MzM3ZmRkMi0xOWI2LTQ5YjQtYmMxNi1kZTViNDM4NWIxMWNfMS5qcGc.jpg"));
                repository.save(new Product("iPhone 15 Pro", "Apple", "Smartphone",
                        "Premium smartphone available for short and long rentals.", 799, 5000,
                        "https://minio-production.eklix.rs/eklix-medusa/c00e54b4-a236-4bf0-96b9-ab14ea1d08f7.webp"));
                repository.save(new Product("Sony Alpha Camera", "Sony", "Camera",
                        "Mirrorless camera for events, travel and content creation.", 699, 4000,
                        "https://images.unsplash.com/photo-1516035069371-29a1b244cc32"));
                repository.save(new Product("iPad Air", "Apple", "Tablet",
                        "Lightweight tablet for study, design and entertainment.", 499, 3000,
                        "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0"));
            }
        };
    }
}
