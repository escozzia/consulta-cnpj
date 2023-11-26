package br.com.smart_br.consulta_cpnj.repository;

import br.com.smart_br.consulta_cpnj.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public interface ICityRepository extends JpaRepository<City, String> {
    @Query("SELECT t FROM City t WHERE t.ibge = ?1")
    City findByIbge(int ibge);
}
