package ca.cmpt213.as4.trivial_model;

import ca.cmpt213.as4.DrawShape.ConcreteDrawableShape;
import ca.cmpt213.as4.ShapeModel;
import ca.cmpt213.as4.DrawShape.DrawableShape;
import ca.cmpt213.as4.UI.Canvas;
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
    private List<ConcreteDrawableShape> shapes = new ArrayList<>();
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
                ConcreteDrawableShape drawableShape = new ConcreteDrawableShape(m);
                shapes.add(drawableShape);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void redact() {
        ShapeDescription redactObject;
        for (int i = 0; i < shapes.size(); i++){
            redactObject = shapes.get(i).getDescription();
            redactObject.setBackground("solid");
            redactObject.setBackgroundColor("light gray");
            redactObject.setFill("solid");
            redactObject.setFillText("X");
            redactObject.setLine("char");
            redactObject.setLineChar("+");
        }
    }

    @Override
    public Iterator<? extends DrawableShape> iterator() {
        return shapes.iterator();
    }


}
