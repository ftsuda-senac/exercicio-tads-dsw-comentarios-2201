package br.senac.tads.dsw.dadospessoais;

import br.senac.tads.dsw.dadospessoais.pessoas.DadosPessoais;
import br.senac.tads.dsw.dadospessoais.pessoas.DadosPessoaisRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DadosPessoaisComentariosApplication implements CommandLineRunner {
    
    @Autowired
    private DadosPessoaisRepository dadosPessoaisRepository;

    public static void main(String[] args) {
        SpringApplication.run(DadosPessoaisComentariosApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (dadosPessoaisRepository.count() == 0) {
            List<DadosPessoais> dados = new ArrayList<>();
            dados.add(new DadosPessoais("João da Silva", "joaosilva", "2000-10-20", "joaosilva@teste.com.br", "(11) 99999-1122", "avatar-joaosilva.jpg"));
            dados.add(new DadosPessoais("José de Souza", "josesouza", "2001-04-07", "josesouza@teste.com.br", "(11) 99999-3455", "avatar-josesouza.jpg"));
            dados.add(new DadosPessoais("Maria dos Santos", "mariasantos", "1999-02-15", "mariasantos@teste.com.br", "(11) 99999-8877", "avatar-mariasantos.jpg"));
            dadosPessoaisRepository.saveAllAndFlush(dados);
        }
    }

}
