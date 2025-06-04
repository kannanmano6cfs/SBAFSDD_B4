package com.learning.excontainerdemo.Repository;

import com.learning.excontainerdemo.Model.Prod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface demoRepository extends JpaRepository<Prod,Integer> {

}
