package controllers;

import com.google.gson.Gson;
import database.DBConnector;
import model.Curriculum;

import java.util.ArrayList;

/**
 * Created by mortenlaursen on 17/10/2016.
 */
public class CurriculumController {

    public ArrayList<Curriculum> getCurriculums() {
        return DBConnector.getCurriculums();
    }

    public Curriculum getCurriculum(int id) {return DBConnector.getCurriculum(id);}

    public boolean editCurriculum(int id) {
        return DBConnector.editCurriculum(id);
    }

    public boolean deleteCurriculum(int id) {
        return DBConnector.deleteCurriculum(id);
    }

    public boolean addCurriculum(String data) {
        Curriculum c = new Gson().fromJson(data,Curriculum.class);
        return DBConnector.addCurriculum(c);
    }

}
