package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

/**
 * Represents the "Taking Off" state of a flight.
 * 
 * This class is part of the State design pattern and implements the {@link State} interface.
 * It indicates that the flight is in the taking off phase, and transitions to the next state,
 * which is "Took Off", when the {@link change} method is called.
 * 
 * The {@link TakingOff} class follows the Singleton design pattern to ensure that only one instance
 * of this state exists throughout the application.
 * 
 * Example use case:
 * - When a flight is in the "Taking Off" state, calling {@link change} transitions it to the "Took Off" state.
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public class TakingOff implements State {
	
	/**
	 * Singleton instance for the TakingOff state
	 */
    private static TakingOff instance = null;

    /**
     *  Private constructor to prevent instantiation from outside
     */
    private TakingOff() { }

    /**
     * Returns the single instance of the TakingOff state.
     * 
     * @return the unique instance of the TakingOff state
     */
    public static TakingOff getIntance() {
        if (instance == null) {
            instance = new TakingOff();
        }
        return instance;
    }

    /**
     * Transitions the flight to the next state, which is TookOff.
     * 
     * @param flight the flight to transition to the next state
     */
    @Override
    public void change(FlightData flight) {
        flight.setState(TookOff.getIntance());
    }
}
