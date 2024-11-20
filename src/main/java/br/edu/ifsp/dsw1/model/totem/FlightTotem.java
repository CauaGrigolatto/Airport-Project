package br.edu.ifsp.dsw1.model.totem;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;

/**
 * Interface that represents a flight totem, which is responsible for displaying flight information.
 * 
 * A flight totem is an object that observes changes in flight data and provides a list of flights
 * currently being observed. It extends the {@link FlightDataObserver} to receive updates when flight
 * information changes. The list of flights can be retrieved for display or processing.
 * 
 * Example usage:
 * - A totem screen in an airport could implement this interface to display flight status updates.
 * - The totem will update its flight list whenever there is a change in the flight data it is observing.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public interface FlightTotem extends FlightDataObserver {

    /**
     * Retrieves the list of flights currently being observed by the totem.
     * 
     * This method returns the list of flights that the totem is displaying or processing.
     * The list is updated whenever a change occurs in the observed flight data.
     * 
     * @return a {@link List} of {@link FlightData} representing the flights being observed
     */
    List<FlightData> getFlights();
}
