package br.edu.ifsp.dsw1.model.totem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;

/**
 * Implementation of the {@link FlightTotem} interface that handles the display of boarding flights.
 * 
 * The {@link BoardingTotemImp} class is a concrete implementation of a flight totem responsible for 
 * displaying information about flights that are in the "boarding" state. It observes the state of flights 
 * and maintains a list of flights that are currently boarding. When a flight transitions to another state, 
 * it will be removed from the list.
 * 
 * Example usage:
 * - This class can be used to implement a display in an airport terminal that shows flights currently boarding.
 * - When a flight is no longer boarding, it will be removed from the list.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public class BoardingTotemImp implements FlightTotem {
    
    /**
     *  List to store boarding flights
     */
    private final List<FlightData> boardingFlights = new ArrayList<FlightData>();
    
    /**
     * Updates the totem with the latest flight information.
     * 
     * This method adds the flight to the boarding flights list if it is in the "boarding" state,
     * or removes it from the list if it transitions to another state.
     * 
     * @param flight the {@link FlightData} object representing the flight to be updated
     */
    @Override
    public void update(FlightData flight) {
        if (!(flight.getState() instanceof Boarding)) {
            boardingFlights.remove(flight);  // Remove if the flight is no longer boarding
        } else if (!boardingFlights.contains(flight)) {
            boardingFlights.add(flight);  // Add if the flight is boarding and not already in the list
        }
    }
    
    /**
     * Retrieves the list of boarding flights currently being displayed on the totem.
     * 
     * This method returns an unmodifiable list of flights that are currently in the "boarding" state.
     * 
     * @return an unmodifiable {@link List} of {@link FlightData} representing the boarding flights
     */
    @Override
    public List<FlightData> getFlights() {
        return Collections.unmodifiableList(boardingFlights);
    }
}
