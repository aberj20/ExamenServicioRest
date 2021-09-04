
package com.examenrest.servicio;

import com.examenrest.dao.ClienteDao;
import com.examenrest.dominio.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente insertarCliente(Cliente cliente) {
        Cliente clienteCreado = clienteDao.save(cliente);
        return clienteCreado;
    }

    public Cliente listarCliente(int id) {
        Optional cliente = clienteDao.findById(id);
        if (cliente.isPresent()) {
            return (Cliente) cliente.get();
        } else {
            return null;
        }
    }

      public Cliente actualizarCliente(Cliente cliente){
       Cliente clienteActualizado= clienteDao.save(cliente);
        return clienteActualizado;
      }
    
    

}
