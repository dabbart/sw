package com.sw.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;

public class BezierCurve {

    Vector2[] points = new Vector2[100];

    public BezierCurve() {

        Vector2[] dataSet = new Vector2[6];
        dataSet[0] = new Vector2(10.0f, 10.0f);
        dataSet[1] = new Vector2(20.0f, 20.0f);
        dataSet[2] = new Vector2(20.0f, 10.0f);
        dataSet[3] = new Vector2(10.0f, 20.0f);
        dataSet[4] = new Vector2(15.0f, 15.0f);
        dataSet[5] = new Vector2(25.0f, 25.0f);

        CatmullRomSpline< Vector2 > myCatmull = new CatmullRomSpline < Vector2 > (dataSet, true);
        for (int i = 0; i < 100; ++i) {

            points[i] = new Vector2();
            myCatmull.valueAt(points[i], ((float) i) / ((float) 100 - 1));
        }
    }

    public void draw(ShapeRenderer sRenderer) {

        sRenderer.begin(ShapeRenderer.ShapeType.Line);
        sRenderer.identity();
        for (int i = 0; i < 100 - 1; ++i) {

            sRenderer.line(points[i], points[i + 1]);
        }
        sRenderer.end();
    }
}
