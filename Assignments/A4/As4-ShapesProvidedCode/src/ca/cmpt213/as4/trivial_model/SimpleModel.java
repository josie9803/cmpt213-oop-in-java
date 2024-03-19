package ca.cmpt213.as4.trivial_model;

import ca.cmpt213.as4.ShapeModel;
import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.ColorMapper;
import ca.cmpt213.as4.UI.DrawableShape;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleModel implements ShapeModel {
    private int top;
    private int left;
    private int width;
    private int height;
    private String background;
    private String backgroundColor;
    private String line;
    private String lineChar;
    private String fill;
    private String fillText;
    private List<DrawableShape> shapes = new ArrayList<>();
    @Override
    public void populateFromJSON(File jsonFile) {
        try {
            FileReader reader = new FileReader(jsonFile);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Type responseType = new TypeToken<ShapeWrapper>(){}.getType();
            ShapeWrapper wrapper = gson.fromJson(reader, responseType);
            List<SimpleModel> data = wrapper.shapes;

            for (SimpleModel m : data){
                Color bgColor = ColorMapper.getColor(m.backgroundColor);
                shapes.add(new DrawableShape() {
                    char character = m.lineChar.charAt(0);

                    @Override
                    public void draw(Canvas canvas) {
                        //print top & bottom border
                        for (int j = 0; j < m.width; j++){
                            canvas.setCellColor(m.left + j, m.top, bgColor);
                            canvas.setCellText(m.left + j, m.top, character);
                            canvas.setCellColor(m.left + j, m.height + m.top, bgColor);
                            canvas.setCellText(m.left + j, m.height + m.top, character);
                        }
                    }
                });
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
