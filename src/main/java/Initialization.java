import by.epam.ticketorder.beans.CreditCard;
import by.epam.ticketorder.beans.Passenger;
import by.epam.ticketorder.beans.Route;
import by.epam.ticketorder.beans.Train;
import by.epam.ticketorder.dao.DAOFactory;
import by.epam.ticketorder.dao.passenger.PassengerDAO;
import by.epam.ticketorder.dao.train.TrainDAO;

import java.util.ArrayList;
import java.util.HashMap;

public class Initialization {
    public static void init() {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();

        PassengerDAO passengerDAO = daoObjectFactory.getPassengerDAO();
        passengerDAO.addPassenger(new Passenger("Nast.asia", "1111", "Анастасия", "Назаревич", "KB654321", new CreditCard("1234 1234 134 1234", 75.0), null));

        // подумать, как закинуть свободные места или чем заменить HashMap
        TrainDAO trainDAO = daoObjectFactory.getTrainDAO();
        trainDAO.addTrain(new Train(new Route("МИНСК", "БРЕСТ", "01.03.22", "12:00", "16:00"), "Эконом-класс", null));
        trainDAO.addTrain(new Train(new Route("МИНСК", "ВИТЕБСК", "01.03.22", "07:30", "12:00"), "Бизнес-класс", null));
        trainDAO.addTrain(new Train(new Route("МИНСК", "ГОМЕЛЬ", "01.03.22", "15:30", "19:00"), "Бизнес-класс", null));
        trainDAO.addTrain(new Train(new Route("МИНСК", "ГРОДНО", "01.03.22", "14:45", "19:15"), "Эконом-класс", null));
        trainDAO.addTrain(new Train(new Route("МИНСК", "МОГИЛЕВ", "01.03.22", "16:20", "19:50"), "Эконом-класс", null));
        trainDAO.addTrain(new Train(new Route("МИНСК", "ОСИПОВИЧИ", "01.03.22", "20:48", "22:02"), "Электричка", null));

        trainDAO.addTrain(new Train(new Route("БРЕСТ", "МИНСК", "01.03.22", "17:00", "21:00"), "Эконом-класс", null));
        trainDAO.addTrain(new Train(new Route("ВИТЕБСК", "МИНСК", "01.03.22", "13:00", "17:30"), "Бизнес-класс", null));
        trainDAO.addTrain(new Train(new Route("ГОМЕЛЬ", "МИНСК", "01.03.22", "20:00", "23:30"), "Бизнес-класс", null));
        trainDAO.addTrain(new Train(new Route("ГРОДНО", "МИНСК", "01.03.22", "09:10", "13:40"), "Эконом-класс", null));
        trainDAO.addTrain(new Train(new Route("МОГИЛЕВ", "МИНСК", "01.03.22", "20:30", "23:50"), "Эконом-класс", null));
        trainDAO.addTrain(new Train(new Route("ОСИПОВИЧИ", "МИНСК", "01.03.22", "21:38", "23:01"), "Электричка", null));

        trainDAO.addTrain(new Train(new Route("TEST", "TEST", "01.01.01", "00:00", "00:00"), "Электричка", null));
    }
}
