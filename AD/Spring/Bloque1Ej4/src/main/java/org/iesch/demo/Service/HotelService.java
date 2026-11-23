package org.iesch.demo.Service;

import lombok.RequiredArgsConstructor;
import org.iesch.demo.modelo.Habitacion;
import org.iesch.demo.modelo.Reserva;
import org.iesch.demo.repositorio.ReservaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final ReservaRepositorio reservaRepositorio;


    public Boolean tieneReservas(Habitacion h){
        // Buscamos si tiene reservas la habitacion
        Optional<List<Reserva>> reservaList = reservaRepositorio.findByhabitacion_Id(h.getId());
        if (reservaList.isPresent()){
            if (!reservaList.get().isEmpty()){
                reservaRepositorio.deleteAll(reservaList.get());
                return true;
            }
        }
        return false;
    }

}
