package br.com.jozias.exchangeservice.repository;

import br.com.jozias.exchangeservice.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    Optional<Exchange> findByFromAndTo(String from, String to);
}
