package com.uniamerica.projetoSpringSecurity2.Controller;

import com.uniamerica.projetoSpringSecurity2.Entity.Usuario;
import com.uniamerica.projetoSpringSecurity2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<?> findById(@PathVariable("id") final long id){
        final Usuario usuario = this.usuarioRep.findById(id).orElse(null);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> lista(){
        return ResponseEntity.ok(this.usuarioRep.findAll());
    }

    @GetMapping("/teste")
    public String teste(){

        System.out.println("entrou");
        return "<h1>Teste</h1>";

    }


    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody final Usuario usuario) {
        try {
            String encodedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encodedPassword);

            this.usuarioRep.save(usuario);
            return ResponseEntity.ok("Cadastrou");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

}
