package com.example.pointofsalebyDulan.repo;

import com.example.pointofsalebyDulan.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByNameAndActiveStatusIs(String item_name, boolean b);
}
