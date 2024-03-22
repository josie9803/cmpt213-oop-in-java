package ca.cmpt213.as4.trivial_model;

import ca.cmpt213.as4.DrawShape.ConcreteDrawableShape;
import ca.cmpt213.as4.ShapeModel;
import ca.cmpt213.as4.DrawShape.DrawableShape;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleModel implements ShapeModel {
    private List<DrawableShape> shapes = new ArrayList<>();
    @Override
    public void populateFromJSON(File jsonFile) {
        try {
            FileReader reader = new FileReader(jsonFile);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Type responseType = new TypeToken<ShapeWrapper>(){}.getType();
            ShapeWrapper wrapper = gson.fromJson(reader, responseType);
            List<ShapeDescription> data = wrapper.shapes;
            shapes.clear();

            for (ShapeDescription m : data){
                DrawableShape drawableShape = new ConcreteDrawableShape(m);
                shapes.add(drawableShape);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void redact() {

    }

    @Override
    public Iterator<? extends DrawableShape> iterator() {
        return shapes.iterator();
    }


}
