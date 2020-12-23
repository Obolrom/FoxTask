package com.romeo.third;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class Task3 extends JFrame {

    public Task3() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        setSize(980,560);

    }

    public void paint(Graphics g) {
        super.paint(g);

//        Cube3D cube = new Cube3D(
//                new Point3D(0,0,0),
//                new Point3D(100, 0, 0),
//                new Point3D(100, 100, 0),
//                new Point3D(0, 100,0),
//
//                new Point3D(100, 0, 50),
//                new Point3D(0,0,100),
//                new Point3D(50, 0, 100),
//                new Point3D(100, 50, 100),
//
//                new Point3D(100, 100, 100),
//                new Point3D(0, 100, 100)
//        );
//
//        Cube3D old = new Cube3D(
//                new Point3D(0 + 100,0+ 100,0+ 100),
//                new Point3D(100+ 100, 0+ 100, 0+ 100),
//                new Point3D(100+ 100, 100+ 100, 0+ 100),
//                new Point3D(0+ 100, 100+ 100,0+ 100),
//
//                new Point3D(100 + 100, 0+ 100, 50+ 100),
//                new Point3D(0+ 100,0+ 100,100+ 100),
//                new Point3D(50+ 100, 0+ 100, 100+ 100),
//                new Point3D(100+ 100, 50+ 100, 100+ 100),
//
//                new Point3D(100+ 100, 100+ 100, 100+ 100),
//                new Point3D(0+ 100, 100+ 100, 100+ 100)
//        );
//
//        Cube3D rotated = old.rotate(Math.toRadians(10), Math.toRadians(10), Math.toRadians(10));
//
////      --------------- orthogonal projections ----------------------
////        Cube3D shiftedRotated1 = rotated.shift(new Point3D(150, 0, 0));
////        Cube3D shiftedRotated2 = rotated.shift(new Point3D(700, 500, 0));
////
////        ProjectedCube projectedToXYPlane = new ProjectedCube(shiftedRotated1.projectToXYPlane());
////        g.setColor(Color.BLUE);
////        projectedToXYPlane.paint(g);
////
////        ProjectedCube projectedToYZPlane = new ProjectedCube(shiftedRotated2.projectToYZPlane());
////        g.setColor(Color.RED);
////        projectedToYZPlane.paint(g);
////
////        ProjectedCube projectedToXZPlane = new ProjectedCube(shiftedRotated2.projectToXZPlane());
////        g.setColor(Color.GREEN);
////        projectedToXZPlane.paint(g);
////      -------------------------------------------------------------
//
////      --------------- axonometric projections ---------------------
//        Cube3D izometric = cube
//                .axonometric(Math.toRadians(45), Math.toRadians(35.26469))
//                .shift(new Point3D(100, 100, 0));
//        Cube3D dimetric = cube
//                .axonometric(Math.toRadians(26.23), Math.toRadians(-29.52))
//                .shift(new Point3D(350, 100, 0));
//        // trimetric proj uses random angles
//        Cube3D trimetric = rotated
//                .axonometric(Math.toRadians(15), Math.toRadians(30))
//                .shift(new Point3D(500, 100, 0));
//
////        ProjectedCube dimetricProjection = new ProjectedCube(dimetric.project());
////        g.setColor(Color.BLUE);
////        dimetricProjection.paint(g);
////
////        ProjectedCube izometricProjection = new ProjectedCube(izometric.project());
////        g.setColor(Color.RED);
////        izometricProjection.paint(g);
////
////        ProjectedCube trimetricProjection = new ProjectedCube(trimetric.project());
////        g.setColor(Color.GREEN);
////        trimetricProjection.paint(g);
////      -------------------------------------------------------------
//
////      ----------  CABINET PROJECTION  -----------------------------
//        Cube3D cabinet  = cube.
//                rotate(Math.toRadians(15), Math.toRadians(5), Math.toRadians(15)).
//                cabinet(Math.toRadians(30), Math.toRadians(60)).
//                shift(new Point3D(100, 100, 0));
//
//        ProjectedCube cabinetProjection = new ProjectedCube(cabinet.project());
//        g.setColor(Color.ORANGE);
////        cabinetProjection.paint(g);
////      -------------------------------------------------------------
//
////      -------------  PERSPECTIVE PROJECTIONS  ---------------------
//        Cube3D onePointPers = cube
//                .perspective(new Point3D(35, 70, 250), 0.7)
//                .shift(new Point3D(100, 150, 0));
//        Cube3D twoPointPers = cube
//                .perspective(new Point3D(35, 70, 200), new Point3D(200, 200, 200), 1.0)
//                .shift(new Point3D(350, 100, 0));
//        Cube3D threePointPers = cube
//                .rotate(Math.toRadians(10), Math.toRadians(10), Math.toRadians(0))
//                .perspective(Math.toRadians(45), Math.toRadians(15), 1.2)
//                .shift(new Point3D(550, 300, 0));
//
//
//        ProjectedCube onePointProjection = new ProjectedCube(onePointPers.project());
//        g.setColor(Color.MAGENTA);
//        onePointProjection.paint(g);
//
//        ProjectedCube twoPointProjection = new ProjectedCube(twoPointPers.project());
//        g.setColor(Color.BLUE);
//        twoPointProjection.paint(g);
//
//        ProjectedCube threePointProjection = new ProjectedCube(threePointPers.project());
//        g.setColor(Color.ORANGE);
//        g.setColor(Color.gray);
//        threePointProjection.paint(g);
////      -------------------------------------------------------------
        LinkedList<Point2D> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new Point2D.Double(100, 100 + i));
        }

        for (int i = 0; i < list.size(); i++) {
            ((Graphics2D) g).draw((Shape) list.get(i));
        }

    }

    public static void main(String[] args) {
        Task3 s = new Task3();
        s.setVisible(true);
    }
}
