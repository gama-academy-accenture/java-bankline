package com.javamos.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javamos.model.Usuario;
import com.javamos.repository.UsuarioRepository;


@Service
public class AppUserDetailService implements UserDetailsService {
	
    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
       Usuario user = userRepository.findByLogin(username).orElse(null);
        if (user==null) {
            throw new UsernameNotFoundException(username);
        }
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getSenhaEncriptada(), authorities);
       
    }
    
}
