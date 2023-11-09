package com.uniamerica.projetoSpringSecurity2.Service;

import com.uniamerica.projetoSpringSecurity2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var userEntity = repository.findByUsername(username);
            System.out.println(userEntity.getUsername());
            System.out.println(userEntity.getPassword());
            return (UserDetails) userEntity;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuário não localizado");
        }
    }
}
