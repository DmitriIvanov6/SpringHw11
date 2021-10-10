package ru.gb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
