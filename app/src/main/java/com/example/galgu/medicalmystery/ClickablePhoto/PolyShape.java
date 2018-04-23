package com.example.galgu.medicalmystery.ClickablePhoto;

import android.graphics.Point;

import com.snatik.polygon.Polygon;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by galgu on 4/4/2018.
 */

public class PolyShape implements Serializable {

    List<RelativePoint> points;
    private float realWidth,realHeight;


    public PolyShape(float realWidth, float realHeight){
        points=new LinkedList<>();
        this.realWidth=realWidth;
        this.realHeight=realHeight;
    }

    public boolean isPoly(){
        return points.size()>2;
    }

    /**
     * This is a java port of the
     * W. Randolph Franklin algorithm explained here
     * http://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html
     */
    public boolean isInArea(float testx, float testy)
    {
        Polygon.Builder polyBuilder= Polygon.Builder();
        for (RelativePoint p:points) {
            polyBuilder.addVertex(new com.snatik.polygon.Point(p.x,p.y));
        }
        return polyBuilder.build().contains(new com.snatik.polygon.Point(testx,testy));
    }

    public void addPoint(float x, float y){
        points.add(new RelativePoint(x/realWidth,y/realHeight));
    }

    public List<RelativePoint>getPoints(){
        return points;
    }

}
