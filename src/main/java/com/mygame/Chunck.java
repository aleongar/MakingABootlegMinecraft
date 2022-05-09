/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygame;

import com.jme3.asset.AssetManager;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.texture.Texture;


/**
 *
 * @author win
 */
public class Chunck extends Node{
    
    private Block[][][] blocks;
    
    public Chunck(AssetManager a){
        super();
        blocks = generateChunk(a);
    }
    
    private Block[][][] generateChunk(AssetManager a){ //optimizar (?)
        Block[][][] tempBlocks = new Block[16][3][16];
        for(int i = 0; i < tempBlocks.length; i++){
            for(int j = 0; j < tempBlocks[i].length; j++){
                for(int k = 0; k < tempBlocks[i][j].length; k++){
                    tempBlocks[i][j][k] = new Block(1/8f,1/8f,1/8f, a);
                    tempBlocks[i][j][k].getMaterial().setColor("Color", ColorRGBA.randomColor());
                    tempBlocks[i][j][k].getGeometry().setLocalTranslation(i/4f, j/4f, k/4f);
                    attachChild(tempBlocks[i][j][k].getGeometry());
                }
            }
        }
        return tempBlocks;
    }
    
    
    
    
    public Block[][][] getBlocks(){
        return blocks;
    }

    
}
