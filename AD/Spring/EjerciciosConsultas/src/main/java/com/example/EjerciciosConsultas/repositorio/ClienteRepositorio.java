package com.example.EjerciciosConsultas.repositorio;

import com.example.EjerciciosConsultas.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    List<Cliente> findDistinctByCochesColorIgnoreCase(String color);

    List<Cliente> findDistinctByCochesPrecioGreaterThan(int precio);
}
