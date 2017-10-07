package com.sw.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class BezierCurve {

    Vector2[] points = new Vector2[100];

    public BezierCurve() {

        Vector2[] dataSet = new Vector2[4];
        dataSet[0] = new Vector2(100.0f + MathUtils.random(-30f, 30f), 100.0f + MathUtils.random(-30f, 30f));
        dataSet[1] = new Vector2(110.0f + MathUtils.random(-30f, 30f), 130.0f + MathUtils.random(-30f, 30f));
        dataSet[2] = new Vector2(130.0f + MathUtils.random(-30f, 30f), 150.0f + MathUtils.random(-30f, 30f));
        dataSet[3] = new Vector2(200.0f + MathUtils.random(-30f, 30f), 200.0f + MathUtils.random(-30f, 30f));

        CatmullRomSpline< Vector2 > myCatmull = new CatmullRomSpline < Vector2 > (dataSet, true);
        for (int i = 0; i < 100; ++i) {

            points[i] = new Vector2();
            myCatmull.valueAt(points[i], ((float) i) / ((float) 100 - 1));
        }
    }

    public void NewRandomDataSet()
    {
        Vector2[] dataSet = new Vector2[4];
        dataSet[0] = new Vector2(100.0f + MathUtils.random(-30f, 30f), 100.0f + MathUtils.random(-30f, 30f));
        dataSet[1] = new Vector2(100.0f + MathUtils.random(-30f, 30f), 600.0f + MathUtils.random(-30f, 30f));
        dataSet[2] = new Vector2(600.0f + MathUtils.random(-30f, 30f), 600.0f + MathUtils.random(-30f, 30f));
        dataSet[3] = new Vector2(600.0f + MathUtils.random(-30f, 30f), 100.0f + MathUtils.random(-30f, 30f));

        CatmullRomSpline< Vector2 > myCatmull = new CatmullRomSpline < Vector2 > (dataSet, true);
        for (int i = 0; i < 100; ++i) {

            points[i] = new Vector2();
            myCatmull.valueAt(points[i], ((float) i) / ((float) 100 - 1));
        }
    }
    public void NewDataSet(Vector2[] dataSet)
    {
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
