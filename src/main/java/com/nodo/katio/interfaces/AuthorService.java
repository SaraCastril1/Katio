package com.nodo.katio.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.models.User;
import com.nodo.katio.services.UserService;

public class AuthorService {
    private String NombreDelAutor;
    private String ApellidoDelAutor;
    private String LugarDeNacimientoDelAutor;
    private String GeneroDelAutor;

    public String getNombreDelAutor() {
        return NombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        NombreDelAutor = nombreDelAutor;
    }

    public String getApellidoDelAutor() {
        return ApellidoDelAutor;
    }

    public void setApellidoDelAutor(String apellidoDelAutor) {
        ApellidoDelAutor = apellidoDelAutor;
    }

    public String getLugarDeNacimientoDelAutor() {
        return LugarDeNacimientoDelAutor;
    }

    public void setLugarDeNacimientoDelAutor(String lugarDeNacimientoDelAutor) {
        LugarDeNacimientoDelAutor = lugarDeNacimientoDelAutor;
    }

    public String getGeneroDelAutor() {
        return GeneroDelAutor;
    }

    public void setGeneroDelAutor(String generoDelAutor) {
        GeneroDelAutor = generoDelAutor;
    }

    public Iterable<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }
}

@RestController
@RequestMapping("/service")

public class Authorervice {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<com.nodo.katio.models.User>> getAllUsers() {
        Iterable<com.nodo.katio.models.User> service = new AuthorService().getAllUsers();
        return ResponseEntity.ok(service);
    }

}