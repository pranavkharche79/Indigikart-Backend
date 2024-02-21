package gikart.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gikart.entities.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

}
