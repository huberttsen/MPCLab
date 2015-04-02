package com.mpc.objects;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.JComponent;


public class ProjectileShooter
{
    private double angleRad = Math.toRadians(45);
    private double power = 50;
    private Projectile projectile;
    private JComponent paintingComponent;

    void setPaintingComponent(JComponent paintingComponent)
    {
        this.paintingComponent = paintingComponent;
    }

    void setAngle(double angleRad)
    {
        this.angleRad = angleRad;
    }

    void setPower(double power)
    {
        this.power = power;
    }

    void shoot()
    {
        Thread t = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                executeShot();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private void executeShot()
    {
        if (projectile != null)
        {
            return;
        }
        projectile = new Projectile();

        Point2D velocity = 
            AffineTransform.getRotateInstance(angleRad).
                transform(new Point2D.Double(1,0), null);
        velocity.setLocation(
            velocity.getX() * power * 0.5, 
            velocity.getY() * power * 0.5);
        projectile.setVelocity(velocity);

        //System.out.println("Initial "+velocity);

        long prevTime = System.nanoTime();
        while (projectile.getPosition().getY() >= 0)
        {
            long currentTime = System.nanoTime();
            double dt = 3 * (currentTime - prevTime) / 1e8;
            projectile.performTimeStep(dt);

            prevTime = currentTime;
            paintingComponent.repaint();
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                return;
            }
        }

        projectile = null;
        paintingComponent.repaint();
    }

    Projectile getProjectile()
    {
        return projectile;
    }
}