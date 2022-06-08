//Pacote
package com.example.arthur.tartaglia.repository;

//Importações
import com.example.arthur.tartaglia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

//Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    //Encontra um cliente pelo nome
    List<Cliente> findByNome(String nome);

    //Encontra um cliente por e-mail
    List<Cliente> findByEmail(String email);

    //Altera o e-mail de um cliente com base em seu nome
    @Transactional
    @Modifying
    @Query("UPDATE Cliente SET cliente_mail = :mail WHERE cliente_nome = :nome")
    Integer updateEmailByNome(String mail, String nome);
}
