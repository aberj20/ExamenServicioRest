package com.examenrest;

import com.examenrest.dominio.Cliente;
import com.examenrest.servicio.ClienteService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ControladorRest {

    @Autowired
    private ClienteService clienteService;
//endpoint para listar los clientes

    @GetMapping("/GET/NutriNET/Cliente")
    public ResponseEntity<List<Cliente>> listarClientes(@RequestParam(required = false) Integer id) {
       
        List<Cliente> clientes = new ArrayList<>();
        if (id == null) {

            clientes = clienteService.listarClientes();
            if (clientes == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(clientes);
            }
        } else {

            Cliente cliente = clienteService.listarCliente(id);

            if (cliente == null) {
                return ResponseEntity.notFound().build();
            } else {
                clientes.add(cliente);
                return ResponseEntity.ok(clientes);
            }
        }

    }
//endpoint para insertar clientes

    @PostMapping("/POST/NutriNET/Cliente")
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {

        Cliente clienteInsertado = clienteService.insertarCliente(cliente);
if(clienteInsertado==null){
 return ResponseEntity.status(-1).build();
}else{
        return new ResponseEntity(clienteInsertado, HttpStatus.CREATED);
}
    }

    //enpoint para actualizar clientes
    @PutMapping("/PUT/NutriNET/Cliente/{id}")
    public ResponseEntity<Cliente> actualizaCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        Cliente clienteAct = clienteService.listarCliente(id);
        if (clienteAct.getClienteId() == id) {
            cliente.setClienteId(id);
            Cliente clienteActualizado = clienteService.actualizarCliente(cliente);
            return new ResponseEntity(clienteActualizado, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
