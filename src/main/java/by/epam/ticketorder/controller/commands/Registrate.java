package by.epam.ticketorder.controller.commands;

import by.epam.ticketorder.beans.CreditCard;
import by.epam.ticketorder.beans.Passenger;
import by.epam.ticketorder.controller.Command;
import by.epam.ticketorder.service.ServiceFactory;
import by.epam.ticketorder.service.passenger.PassengerService;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Registrate implements Command {
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public String execute(ArrayList<String> request) {
        logger.debug("Registrate method is started.");
        String name = request.get(1);
        String surname = request.get(2);
        String passportNumber = request.get(3);
        CreditCard creditCard = new CreditCard(
                request.get(4),
                Double.parseDouble(request.get(5))
        );
        String login = request.get(6);
        String password = request.get(7);
        Passenger passenger = new Passenger(login, password, name, surname, passportNumber, creditCard, null);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        PassengerService passengerService = serviceFactory.getPassengerService();

        try {
            passengerService.registrate(passenger);
            logger.debug("Registrate method is closed.");
            return "TICKET_MENU";
        } catch (Exception e) {
            logger.debug("Registrate method is closed.");
            logger.error(e.getMessage());
            return "WRONG_REQUEST";
        }
    }
}
