package br.edu.ifsp.dsw1.model.entity;

import br.edu.ifsp.dsw1.model.flightstates.State;

/**
 * Represents the essential data of a flight, including flight number, company, time, and state.
 * 
 * This class serves as an immutable representation of a flight's core attributes, with the exception 
 * of its state, which can be updated to reflect changes in the flight's status. It is used throughout 
 * the application to manage and process flight-related information.
 * 
 * Example usage:
 * - Storing flight information retrieved from user inputs or a database.
 * - Updating the state of a flight during its lifecycle.
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public final class FlightData {

    /**
     * The unique identifier of the flight.
     */
    private final Long flightNumber;

    /**
     * The name of the company operating the flight.
     */
    private final String company;

    /**
     * The scheduled time of the flight.
     */
    private final String time;

    /**
     * The current state of the flight.
     */
    private State state;

    /**
     * Constructs a new FlightData instance with the specified flight details.
     * 
     * @param flightNumber the unique identifier of the flight
     * @param company the name of the company operating the flight
     * @param time the arrival time of the flight
     */
    public FlightData(Long flightNumber, String company, String time) {
        super();
        this.flightNumber = flightNumber;
        this.company = company;
        this.time = time;
    }

    /**
     * Gets the current state of the flight.
     * 
     * @return the current state of the flight
     */
    public State getState() {
        return state;
    }

    /**
     * Updates the current state of the flight.
     * 
     * @param state the new state of the flight
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets the flight number.
     * 
     * @return the flight number
     */
    public Long getFlightNumber() {
        return flightNumber;
    }

    /**
     * Gets the name of the company operating the flight.
     * 
     * @return the company name
     */
    public String getCompany() {
        return company;
    }

    /**
     * Gets the scheduled time of the flight.
     * 
     * @return the flight's arrival time
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns a string representation of the FlightData object.
     * 
     * @return a string with flight number, company, time, and current state
     */
    @Override
    public String toString() {
        return "FlightData [flightNumber=" + flightNumber + 
               ", company=" + company + 
               ", time=" + time + 
               ", state=" + state.getClass().getSimpleName() + "]";
    }
}
