package ua.epam.project4.controller.command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by danik on 14.01.2016.
 */
public class CommandFactory {

    private static CommandFactory instance;

    private Map<String, Command> commands;

    private CommandFactory(){
        commands = new HashMap<String, Command>();
        commands.put("login", new CommandLogin());
        commands.put("users", new CommandGetUsers());
        commands.put("registration", new CommandRegistration());
        commands.put("drinks", new CommandGetDrinks());
        commands.put("ingredients", new CommandGetIngredients());
        commands.put("addIngredient", new CommandAddIngredient());
        commands.put("balance", new CommandAddBalance());
        commands.put("getWater", new CommandTakeDrink());
        commands.put("operations", new CommandGetOperations());
        commands.put("logout", new CommandLogout());
    }

    public static CommandFactory getInstance(){
        if(instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(String command) {
        return commands.get(command);
    }
}
