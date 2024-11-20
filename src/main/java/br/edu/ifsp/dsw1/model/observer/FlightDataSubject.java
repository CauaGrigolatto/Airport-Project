package br.edu.ifsp.dsw1.model.observer;

/**
 * Interface that defines the behavior of a subject that maintains a list of observers.
 * 
 * This interface is part of the Observer design pattern, where the subject is the
 * object being observed (in this case, the flight data). It provides methods to register, 
 * unregister, and notify all registered observers when a change occurs.
 * 
 * @author Ednilson Geraldo Rossi
 * @version 1.0
 */
public interface FlightDataSubject {

    /**
     * Registers an observer to receive notifications about changes to the flight data.
     * 
     * This method adds an observer to the list of observers. The observer will be notified
     * whenever the subject's state changes.
     * 
     * @param observer the {@link FlightDataObserver} to register
     */
    void register(FlightDataObserver observer);

    /**
     * Unregisters an observer so that it no longer receives notifications about changes
     * to the flight data.
     * 
     * @param observer the {@link FlightDataObserver} to unregister
     */
    void unregister(FlightDataObserver observer);

    /**
     * Notifies all registered observers of a change in the subject's state.
     * 
     * This method is called when there is a change in the flight data, and all observers
     * will be updated with the new flight information.
     */
    void notifyObservers();
}
