package br.senac.tads.dsw.dadospessoais.pessoas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Integer> {

}
