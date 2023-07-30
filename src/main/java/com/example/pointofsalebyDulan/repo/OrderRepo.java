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

    @Query(value = "select c.customer_name as customerName, c.customer_address as customerAddress, c.contact_number as contactNumber, " +
            "o.order_date as date, o.total as total from customer c,orders o where o.active_state=?1 and c.customer_id = o.customer_id",nativeQuery = true)
    List<OrderDetailsInterface> getAllOrders(boolean status, Pageable pageable);


    @Query(value = "select count(*) from customer c, order o where " +
            "c.active_status = ?1 and c.customer_id=o.customer_id", nativeQuery = true)
    long getCount(boolean status);
}
