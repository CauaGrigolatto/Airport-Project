package br.edu.ifsp.dsw1.model.totem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;

/**
 * Implementation of the {@link FlightTotem} interface that handles the display of arriving flights.
 * 
 * The {@link ArrivingTotemImp} class is a concrete implementation of a flight totem responsible for 
 * displaying information about flights that are arriving. It observes the state of flights and keeps
 * track of the ones that are currently in the "arriving" state. Only flights in the "arriving" state 
 * will be added to the list, and flights will be removed once they transition to another state.
 * 
 * Example usage:
 * - This class can be used to implement a screen in an airport that only shows arriving flights.
 * - When a flight transitions out of the "arriving" state, it will be removed from the list.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public class ArrivingTotemImp implements FlightTotem {
    
    /**
     *  List to store arriving flights
     */
    private List<FlightData> arrivingFlights = new ArrayList<FlightData>();
    
    /**
     * Updates the totem with the latest flight information.
     * 
     * This method adds the flight to the arriving flights list if it is in the "arriving" state,
     * or removes it from the list if it transitions to another state.
     * 
     * @param flight the {@link FlightData} object representing the flight to be updated
     */
    @Override
    public void update(FlightData flight) {
        if (!(flight.getState() instanceof Arriving)) {
            arrivingFlights.remove(flight);  // Remove if the flight is no longer arriving
        } else if (!arrivingFlights.contains(flight)) {
            arrivingFlights.add(flight);  // Add if the flight is arriving and not already in the list
        }
    }
    
    /**
     * Retrieves the list of arriving flights currently being displayed on the totem.
     * 
     * This method returns an unmodifiable list of flights that are currently in the "arriving" state.
     * 
     * @return an unmodifiable {@link List} of {@link FlightData} representing the arriving flights
     */
    @Override
    public List<FlightData> getFlights() {
        return Collections.unmodifiableList(arrivingFlights);
    }
}
