package lesson04.com.company.controller;


import lesson04.com.company.model.Model;
import lesson04.com.company.view.View;

import java.util.Scanner;

/**
 * Created by student on 03.09.2021.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        InputNoteNoteBook inputNoteNoteBook =
                new InputNoteNoteBook(view, sc);
        inputNoteNoteBook.inputNote();
    }
}
