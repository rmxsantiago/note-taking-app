package ie.rmxsantiago.notetaking.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ie.rmxsantiago.notetaking.model.pojos.Category;
import ie.rmxsantiago.notetaking.model.pojos.Note;

/**
 * Created by rmxsantiago on 28/03/2018.
 */

public class DataManager {
    private static List<Note> notes;
    private static List<Category> categories;

    static {
        categories = new ArrayList<Category>();
        notes = new ArrayList<Note>();

        categories.add(new Category("Test 1"));
        categories.add(new Category("Teste 2"));
        categories.add(new Category("Teste 3"));
        categories.add(new Category("Teste 4"));

        notes.add(new Note("Note 1", "Note body example", new Category("Test 1")));
    }

    private DataManager() {
    }

    public static List<Category> getCategories(){
        return categories;
    }

    public static List<Note> getNotes(){
        return notes;
    }
}
