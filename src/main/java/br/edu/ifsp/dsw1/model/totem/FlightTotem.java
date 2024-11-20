package br.edu.ifsp.dsw1.model.totem;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;

public interface FlightTotem extends FlightDataObserver {
	List<FlightData> getFlights();
}
