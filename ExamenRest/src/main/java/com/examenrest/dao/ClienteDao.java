/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examenrest.dao;

import com.examenrest.dominio.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lenovo
 */
public interface ClienteDao extends CrudRepository<Cliente,Integer>{
    
}
