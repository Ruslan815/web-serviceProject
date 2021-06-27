package main;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.printConnectInfo();
        dbService.createTable();
        try {
            long userId = dbService.addUser("dog");
            System.out.println("Added user id: " + userId);
            userId = dbService.addUser("giraffe");
            System.out.println("Added user id: " + userId);
            userId = dbService.addUser("elephant");
            System.out.println("Added user id: " + userId);
            userId = dbService.addUser("cat");
            System.out.println("Added user id: " + userId);

            UsersDataSet dataSet = dbService.getUser(userId);
            System.out.println("User data set: " + dataSet);

            if (Math.random() > 0.5) {
                dbService.cleanUp();
                System.out.println("Table was deleted.");
            }
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
