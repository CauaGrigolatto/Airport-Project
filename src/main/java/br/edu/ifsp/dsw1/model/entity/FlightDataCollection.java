package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;
import br.edu.ifsp.dsw1.model.observer.FlightDataSubject;

/**
 * Represents a collection of flights and implements the observer pattern 
 * to notify registered observers about changes to the flights.
 * 
 * This class acts as the central repository for managing flight data, 
 * providing methods for inserting, updating, and retrieving flights.
 * It also ensures that any changes to a flight are communicated to 
 * registered observers.
 * 
 * Example usage:
 * - Managing a list of flights in an application that tracks flight statuses.
 * - Notifying observers (e.g., UI components) when flights are added or updated.
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public class FlightDataCollection implements FlightDataSubject {

    /**
     * A list containing all the registered flights.
     */
    private List<FlightData> flights;

    /**
     * A list of observers that are notified when changes occur to the flights.
     */
    private List<FlightDataObserver> observers;

    /**
     * The last updated flight, used to notify observers about specific changes.
     */
    private FlightData lastUpdated;

    /**
     * Initializes a new FlightDataCollection instance with empty lists of flights and observers.
     */
    public FlightDataCollection() {
        this.flights = new LinkedList<>();
        this.observers = new LinkedList<>();
    }

    /**
     * Registers an observer to be notified of changes in the flight collection.
     * 
     * @param observer the observer to register
     */
    @Override
    public void register(FlightDataObserver observer) {
        observers.add(observer);
    }

    /**
     * Unregisters an observer, removing it from the notification list.
     * 
     * @param observer the observer to unregister
     */
    @Override
    public void unregister(FlightDataObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers about the last updated flight.
     */
    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.update(lastUpdated));
    }

    /**
     * Inserts a new-not-null flight into the collection and notifies observers.
     * 
     * @param flight the flight to insert
     */
    public void insertFlight(FlightData flight) {
        if (flight != null) {
            lastUpdated = flight;
            flights.add(flight);
            notifyObservers();
        }
    }

    /**
     * Updates the state of a flight identified by its flight number. 
     * If the flight has taken off, it is removed from the collection. 
     * Observers are notified after the update.
     * 
     * @param flightNumber the unique number of the flight to update
     */
    public void updateFlight(Long flightNumber) {
        var flight = findByNumber(flightNumber);
        if (flight != null) {
            flight.getState().change(flight);
            if (flight.getState() instanceof TookOff) {
                flights.remove(flight);
            }
            lastUpdated = flight;
            notifyObservers();
        }
    }

    /**
     * Retrieves a list of all flights currently in the collection.
     * 
     * @return a list containing all flights
     */
    public List<FlightData> getAllFligthts() {
        return new ArrayList<>(flights);
    }

    /**
     * Finds a flight by its unique flight number.
     * 
     * @param flightNumber the unique number of the flight to find
     * @return the flight with the specified number, or null if not found
     */
    public FlightData findByNumber(Long flightNumber) {
        return flights.stream()
                      .filter(flight -> flight.getFlightNumber().equals(flightNumber))
                      .findFirst()
                      .orElse(null);
    }
}
