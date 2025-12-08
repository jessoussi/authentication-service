package org.sample.devops.service.authentication.exposition;

import org.sample.devops.service.authentication.domain.User;
import org.sample.devops.service.authentication.infra.UserEntity;
import org.sample.devops.service.authentication.domain.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        Optional<User> userOptional = authenticationService.authenticate(authenticationRequest.mail(), authenticationRequest.password());
        if (userOptional.isPresent()){
            User user = userOptional.get();
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(user.getMail(), user.getFirstname(), user.getLastname(), user.getVille());
            return ResponseEntity.ok(authenticationResponse);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
