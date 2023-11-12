package org.ws_solutions.view;


import org.ws_solutions.controller.ControllerBase;
import org.ws_solutions.Router;

import javax.swing.*;

abstract class TelaBase {
    Router router;

    ControllerBase controllerBase;

    public TelaBase(Router router) {
        this.router = router;
    }

    protected void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}