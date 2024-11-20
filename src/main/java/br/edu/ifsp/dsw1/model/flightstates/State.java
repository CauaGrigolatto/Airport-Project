package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

/**
 * Represents the state of a flight in the system.
 * 
 * This interface is part of the State design pattern, allowing different states
 * of a flight (e.g., Arriving, Boarding, Taking Off, Took Off) to implement specific 
 * behavior for state transitions.
 * 
 * Implementing classes define how a flight transitions from one state to another.
 * 
 * Example use case:
 * - A flight's state is updated based on its progress (e.g., changing from Boarding to Took Off).
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public interface State {

    /**
     * Performs the transition logic for the flight to its next state.
     * 
     * @param flight the flight whose state is being changed
     */
    void change(FlightData flight);

}
