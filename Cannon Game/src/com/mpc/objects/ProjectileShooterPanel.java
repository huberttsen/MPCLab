package com.mpc.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;




class ProjectileShooterPanel extends JPanel
{
    private final ProjectileShooter projectileShooter;

    public ProjectileShooterPanel(ProjectileShooter projectileShooter)
    {
        this.projectileShooter = projectileShooter;
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;

        Projectile projectile = projectileShooter.getProjectile();
        if (projectile != null)
        {
            g.setColor(Color.RED);
            Point2D position = projectile.getPosition();
            int x = (int)position.getX();
            int y = getHeight() - (int)position.getY();
            g.fillOval(x-01, y-10, 20, 20);
        }
    }
}