/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygame;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;

/**
 *
 * @author win
 */
public class World extends Node{
    
    AssetManager a;
    Chunck[][] chuncks;
    
    public World(AssetManager a){
        super();
        this.a = a;
        chuncks = generateWorld();
    }
    
    private Chunck[][] generateWorld(){
        Chunck[][] tempChuncks = new Chunck[5][5];
        for(int i = 0; i < tempChuncks.length; i++){
            for(int j = 0; j < tempChuncks[i].length; j++){
                tempChuncks[i][j] = new Chunck(a);
                tempChuncks[i][j].setLocalTranslation(i*4.0f, tempChuncks[i][j].getLocalTranslation().y, j*4.0f);
                attachChild(tempChuncks[i][j]);
            }
        }
        return tempChuncks;
    }
    
    
}
