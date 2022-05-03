package br.senac.tads.dsw.dadospessoais.pessoas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pessoa")
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String apelido;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // ISO-8601
    @PastOrPresent
    @NotNull
    private LocalDate dataNascimento;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Size(max = 20)
    private String telefone;

    private String arquivoFoto;

    public DadosPessoais() {

    }

    public DadosPessoais(String nome, String apelido, String dataNascimento, String email, String telefone, String arquivoFoto) {
        this.setNome(nome);
        this.setApelido(apelido);
        this.setDataNascimento(LocalDate.parse(dataNascimento));
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setArquivoFoto(arquivoFoto);
    }

    public DadosPessoais(Integer id, String nome, String apelido, String dataNascimento, String email, String telefone, String arquivoFoto) {
        this(nome, apelido, dataNascimento, email, telefone, arquivoFoto);
        this.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getArquivoFoto() {
        return arquivoFoto;
    }

    public void setArquivoFoto(String arquivoFoto) {
        this.arquivoFoto = arquivoFoto;
    }

    /*
     * ######## METODOS UTILITARIOS PARA USAR NOS TEMPLATES ########
     */
    public long getIdade() {
        if (this.getDataNascimento() != null) {
            return ChronoUnit.YEARS.between(this.getDataNascimento(), LocalDate.now());
        }
        return 0;
    }

    public String getLinkedinUrl() {
        return "https://br.linkedin.com/in/" + apelido;
    }

    public String getGithubUrl() {
        return "https://github.com/" + apelido;
    }

}
