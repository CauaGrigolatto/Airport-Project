package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

/**
 * Represents the "Took Off" state of a flight.
 * 
 * This class is part of the State design pattern and implements the {@link State} interface.
 * It indicates that the flight has taken off and is in the "Took Off" phase.
 * 
 * The {@link TookOff} class follows the Singleton design pattern to ensure that only one instance
 * of this state exists throughout the application.
 * 
 * Example use case:
 * - When a flight is in the "Taking Off" state and successfully takes off, it transitions to the "Took Off" state.
 * - After this state, no further transitions are defined in the current implementation.
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public class TookOff implements State {

    /**
     *  Singleton instance for the TookOff state
     */
    private static TookOff instance = null;

    /**
     *  Private constructor to prevent instantiation from outside
     */
    private TookOff() { }

    /**
     * Returns the single instance of the TookOff state.
     * 
     * @return the unique instance of the TookOff state
     */
    public static TookOff getIntance() {
        if (instance == null) {
            instance = new TookOff();
        }
        return instance;
    }

    /**
     * This method does not perform any action, as the flight has reached the final state of "Took Off."
     * 
     * @param flight the flight in the "Took Off" state
     */
    @Override
    public void change(FlightData flight) {
    	
    }
}
