/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examenrest.servicio;

import com.examenrest.dominio.Cliente;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface  ClienteService {
    
    public List <Cliente> listarClientes();
    
    public Cliente insertarCliente(Cliente cliente);
    
       public Cliente actualizarCliente(Cliente cliente);
       
    public Cliente listarCliente(int id);
    
   
}
