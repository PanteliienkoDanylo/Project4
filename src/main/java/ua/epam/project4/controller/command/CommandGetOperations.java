package ua.epam.project4.controller.command;

import ua.epam.project4.model.dao.entities.Operation;
import ua.epam.project4.model.dao.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by danik on 01.02.2016.
 */
public class CommandGetOperations extends Command {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Operation> operations = DAO_FACTORY.createOperationDao().findAllOperations();

        request.setAttribute(OPERATIONS, operations);

        return OPERATIONS_PAGE;
    }
}
