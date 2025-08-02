package com.lucasgalliani.hr_oauth.service;

import com.lucasgalliani.hr_oauth.entity.User;
import com.lucasgalliani.hr_oauth.feignclient.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserFeignClient userFeignClient;

    public User findByEmail(String email){
        logger.info("Buscando usuário pelo email: {}", email);
        User user = userFeignClient.findByEmail(email).getBody();

        if (user == null){
            logger.warn("Usuário não encontrado para o email: {}", email);
            throw new IllegalArgumentException("Email not found!");
        }

        logger.info("Usuário encontrado: {}", user.getEmail());
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Tentando carregar usuário para autenticação: {}", username);
        User user = userFeignClient.findByEmail(username).getBody();

        if (user == null){
            logger.warn("Usuário não encontrado durante autenticação: {}", username);
            throw new UsernameNotFoundException("Email not found!");
        }

        logger.info("Senha do usuário para autenticação (hash): {}", user.getPassword());
        logger.info("Usuário carregado com sucesso: {}", user.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("12345");
        logger.info("CRYPT no configure: {}", encodedPassword);

        return user;
    }
}
