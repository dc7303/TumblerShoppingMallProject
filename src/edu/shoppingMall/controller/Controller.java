package edu.shoppingMall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller Interface
 * @author mark
 *
 */
public interface Controller {
    void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
