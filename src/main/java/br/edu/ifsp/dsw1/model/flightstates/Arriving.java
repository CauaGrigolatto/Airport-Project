package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

/**
 * Represents the "Arriving" state of a flight.
 * 
 * This class is part of the State design pattern and implements the {@link State} interface.
 * It indicates that the flight is in the arriving phase, and transitions to the next state,
 * which is "Boarding", when the {@link change} method is called.
 * 
 * The {@link Arriving} class follows the Singleton design pattern to ensure that only one instance
 * of this state exists throughout the application.
 * 
 * Example use case:
 * - When a flight is in the "Arriving" state, calling {@link change} transitions it to the "Boarding" state.
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public class Arriving implements State {
	/**
	 * Singleton instance for the Arriving state
	 */
    private static Arriving instance = null;

    /**
     * Private constructor to prevent instantiation from outside
     */
    private Arriving() { }

    /**
     * Returns the single instance of the Arriving state.
     * 
     * @return the unique instance of the Arriving state
     */
    public static Arriving getIntance() {
        if (instance == null) {
            instance = new Arriving();
        }
        return instance;
    }

    /**
     * Transitions the flight to the next state, which is Boarding.
     * 
     * @param flight the flight to transition to the next state
     */
    @Override
    public void change(FlightData flight) {
        flight.setState(Boarding.getIntance());
    }
}
