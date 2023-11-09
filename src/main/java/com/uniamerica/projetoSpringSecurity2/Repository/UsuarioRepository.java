package com.uniamerica.projetoSpringSecurity2.Repository;

import com.uniamerica.projetoSpringSecurity2.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Usuario findByUsername(String username);

}
