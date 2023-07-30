package com.example.pointofsalebyDulan.repo;

import com.example.pointofsalebyDulan.dto.QueryInterface.OrderDetailsInterface;
import com.example.pointofsalebyDulan.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query(value = "",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrders(boolean status, Pageable pageable);

    //1.50.00
}
