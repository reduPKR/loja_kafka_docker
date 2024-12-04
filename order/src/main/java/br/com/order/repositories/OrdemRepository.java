package br.com.order.repositories;

import br.com.order.entity.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<Ordem, Long> {
}
