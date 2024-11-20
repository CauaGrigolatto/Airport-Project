package br.edu.ifsp.dsw1.model.totem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;

/**
 * Implementation of the {@link FlightTotem} interface that handles the display of flights that are taking off.
 * 
 * The {@link TakingOffTotemImp} class is a concrete implementation of a flight totem responsible for 
 * displaying information about flights that are in the "taking off" state. It observes the state of flights 
 * and maintains a list of flights that are currently taking off. When a flight transitions to another state, 
 * it will be removed from the list.
 * 
 * Example usage:
 * - This class can be used to implement a display in an airport terminal showing flights that are taking off.
 * - When a flight transitions to another state (e.g., "took off"), it will be removed from the list.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public class TakingOffTotemImp implements FlightTotem {
    
    /**
     *  List to store taking off flights
     */
    private final List<FlightData> takingOffFlights = new ArrayList<FlightData>();
    
    /**
     * Updates the totem with the latest flight information.
     * 
     * This method adds the flight to the taking off flights list if it is in the "taking off" state,
     * or removes it from the list if it transitions to another state.
     * 
     * @param flight the {@link FlightData} object representing the flight to be updated
     */
    @Override
    public void update(FlightData flight) {
        if (!(flight.getState() instanceof TakingOff)) {
            takingOffFlights.remove(flight);  // Remove if the flight is no longer taking off
        } else if (!takingOffFlights.contains(flight)) {
            takingOffFlights.add(flight);  // Add if the flight is taking off and not already in the list
        }
    }
    
    /**
     * Retrieves the list of taking off flights currently being displayed on the totem.
     * 
     * This method returns an unmodifiable list of flights that are currently in the "taking off" state.
     * 
     * @return an unmodifiable {@link List} of {@link FlightData} representing the taking off flights
     */
    @Override
    public List<FlightData> getFlights() {
        return Collections.unmodifiableList(takingOffFlights);
    }
}
