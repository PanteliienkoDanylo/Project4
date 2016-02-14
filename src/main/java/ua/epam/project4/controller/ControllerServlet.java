package ua.epam.project4.controller;

import ua.epam.project4.controller.command.Command;
import ua.epam.project4.controller.command.CommandFactory;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Controller servlet
 *
 * Created by danik on 11.01.2016.
 */

public class ControllerServlet extends HttpServlet {
    /**
     * Command
     */
    public static final String COMMAND = "command";

    /**
     * Charset
     */
    public static final String CHARSET = "UTF-8";

    /**
     * From
     */
    public static final String FROM = "from";

    /**
     * Factory for command
     */
    private CommandFactory commandFactory;

    /**
     * Constructor for initialization
     */
    public ControllerServlet(){
        commandFactory = CommandFactory.getInstance();
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding(CHARSET);

        try {
            String commandString = request.getParameter(COMMAND);
            Command command = commandFactory.getCommand(commandString);
            String path = command.execute(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        }catch (Exception ex){
            //response.sendRedirect(request.getParameter(FROM));
            String from = request.getParameter(FROM);
            request.getRequestDispatcher(from.substring(from.indexOf('/', 0))).forward(request, response);
        }




    }



}
