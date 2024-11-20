package br.edu.ifsp.dsw1.model.observer;

import br.edu.ifsp.dsw1.model.entity.FlightData;

/**
 * Interface that defines the behavior of a flight data observer.
 * 
 * This interface is used in the Observer design pattern to allow objects
 * (observers) to be notified of changes in the state of an observed object
 * (in this case, a {@link FlightData} object). The observer reacts to these changes
 * and updates its information as needed.
 * 
 * Example usage:
 * - An observer can be implemented to monitor changes in the state of a flight,
 *   such as when the flight arrives or takes off, and take appropriate actions.
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public interface FlightDataObserver {

    /**
     * Updates the observer with the new flight information.
     * 
     * This method is called whenever a change occurs in the observed object, so
     * the observer should process the flight data.
     * 
     * @param flight the {@link FlightData} object that was updated
     */
    void update(FlightData flight);
}
