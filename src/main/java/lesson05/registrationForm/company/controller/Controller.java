package lesson05.registrationForm.company.controller;


import lesson05.registrationForm.company.model.Model;
import lesson05.registrationForm.company.model.entity.NotUniqueLoginException;
import lesson05.registrationForm.company.model.entity.NoteBook;
import lesson05.registrationForm.company.view.View;

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
        InputNoteNoteBook inputNoteNoteBook = new InputNoteNoteBook(view, sc);
        inputNoteNoteBook.inputNote();

        NoteBook noteBook = getNoteBook(inputNoteNoteBook);
        System.out.println(noteBook);
    }

    private NoteBook getNoteBook(InputNoteNoteBook inputNoteNoteBook) {
        NoteBook noteBook = null;
        while(true) {
            try {
                noteBook = new NoteBook(inputNoteNoteBook.getFirstName(),
                        inputNoteNoteBook.getLoginData());
                break;
            } catch (NotUniqueLoginException e) {
                e.printStackTrace();
                System.out.println("Not Unique Login " + e.getLoginData());
                inputNoteNoteBook.inputLogin();
            }
        }
        return noteBook;
    }
}