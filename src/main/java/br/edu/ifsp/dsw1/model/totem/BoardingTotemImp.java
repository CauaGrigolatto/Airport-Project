package br.edu.ifsp.dsw1.model.totem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;

public class BoardingTotemImp implements FlightTotem {
	private final List<FlightData> boardingFlights = new ArrayList<FlightData>();
	
	@Override
	public void update(FlightData flight) {
		if (! (flight.getState() instanceof Boarding)) {
			boardingFlights.remove(flight);
		}
		else if (! boardingFlights.contains(flight)) {
			boardingFlights.add(flight);
		}
	}
	
	@Override
	public List<FlightData> getFlights() {
		return Collections.unmodifiableList(boardingFlights);
	}
}
