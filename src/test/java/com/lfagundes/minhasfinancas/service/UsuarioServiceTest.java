package com.lfagundes.minhasfinancas.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lfagundes.minhasfinancas.exception.RegraNegocioException;
import com.lfagundes.minhasfinancas.model.entity.Usuario;
import com.lfagundes.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test()
	public void deveValidarEmail()
	{
		Assertions.assertDoesNotThrow(() -> {
			repository.deleteAll();
			
			service.validarEmail("email@email.com");
		});
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado()
	{
	
		Assertions.assertThrows(RegraNegocioException.class, () -> {
			Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();
			repository.save(usuario);
			
			service.validarEmail("email@email.com");
		});
		
	}
}
