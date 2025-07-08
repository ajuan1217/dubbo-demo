package org.example.second.provider.repository;

import org.example.second.provider.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByName(String name);

}
