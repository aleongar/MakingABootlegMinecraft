/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 * @author win
 */
public class Block extends Box{
    private int life;
    Geometry geom;
    Material mat;
    AssetManager a;
            
    public Block(AssetManager a){
        super();
        this.a = a;
        geom = new Geometry("Block", this);
        mat = new Material(a, "Common/MatDefs/Misc/Unshaded.j3md");
        geom.setMaterial(mat);
        life = 100;
    }
    
    public Block(float x, float y, float z, AssetManager a){
        super(x,y,z);
        this.a = a;
        geom = new Geometry("Block", this);
        mat = new Material(a, "Common/MatDefs/Misc/Unshaded.j3md");
        geom.setMaterial(mat);
        life = 100;
    }  
    
    public Geometry getGeometry(){
        return geom;
    }
    
    public Material getMaterial(){
        return mat;
    }
}
