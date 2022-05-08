
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorycustomer extends JpaRepository<Usercls, Long> {
        Usercls findByEmail(String email);
}