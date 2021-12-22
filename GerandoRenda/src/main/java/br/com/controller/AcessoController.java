package br.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.configs.JwtUtils;
import br.com.model.User;
import br.com.repository.RoleRepository;
import br.com.repository.UserRepository;
import br.com.service.UserDetailsImpl;
import br.com.utils.JwtResponse;
import br.com.utils.LoginRequest;



@RequestMapping({ "v1/admin/auth" })
@RestController
@Api("Acesso")
public class AcessoController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	
	
	@CrossOrigin
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getSenha() ));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		JwtResponse resposta = new JwtResponse(token, userDetails.getId(), roles);
		
	 	return ResponseEntity.ok(resposta);
	}
	
	
	@CrossOrigin
	@ApiOperation(value = "Listar por Id")
	@GetMapping("/listar/{id}")
	@PreAuthorize("hasRole('TECNICO')")
	public Optional<User> listarPorId(@PathVariable int id) {
		Optional<User> user =  userRepository.findById(id);
		return user;
	}
	
	@CrossOrigin
	@ApiOperation(value = "Listar Operadores")
	@GetMapping("/listarOperadores")
	@PreAuthorize("hasRole('TECNICO') or hasRole('ADMIN')")
	public List<User> listarOperadores() {
		List<User> operadores =  userRepository.listarOperadores();
		return operadores;
	}
	
	
	
}