package edu.greenriver.sdev.morespringproj.service;

import edu.greenriver.sdev.morespringproj.model.Surfboard;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurfboardService {
    private List<Surfboard> products = List.of(
            new Surfboard("Boogie", 199.99, 6.5, "red", true),
            new Surfboard("Surf Inc", 99.99, 5.5, "green", false),
            new Surfboard("Acme Company", 399.99, 5, "yellow", false),
            new Surfboard("Surfshark", 499.99, 4.5, "blue-teal", true)
    );

    public List<Surfboard> getAll()
    {
        return products;
    }

    public List<Surfboard> getOnSale()
    {
        return products
                .stream()
                .filter(product -> product.isOnSale())
                .collect(Collectors.toList());
    }

}
