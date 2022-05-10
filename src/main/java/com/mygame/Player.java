package com.mygame;


import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.objects.PhysicsCharacter;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author win
 */
public class Player extends Node implements ActionListener{
    
    private boolean left=false,right=false,up=false,down=false;
    private BulletAppState bulletAppState;
    private PhysicsCharacter player;
    final private Vector3f walkDirection = new Vector3f();
    private AppStateManager stateManager;
    private FlyByCamera flyCam;
    private InputManager inputManager;
    private Camera cam;
    private DirectionalLight dl;
    private AmbientLight am;
    
    public Player(AppStateManager stateManager, FlyByCamera flyCam, InputManager inputManager, Camera cam){
        this.stateManager = stateManager;
        this.flyCam = flyCam;
        this.inputManager = inputManager;
        bulletAppState = new BulletAppState();
        this.stateManager.attach(bulletAppState);
        
        flyCam.setMoveSpeed(100);
        
        setupKeys();
        
        this.cam.setFrustumFar(2000);
        dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White.clone().multLocal(2));
        dl.setDirection(new Vector3f(-1, -1, -1).normalize());
        
        am = new AmbientLight();
        am.setColor(ColorRGBA.White.mult(2));
    }
    
    private void setupKeys() {
        inputManager.addMapping("Lefts", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Rights", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Ups", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Downs", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Space", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(this,"Lefts");
        inputManager.addListener(this,"Rights");
        inputManager.addListener(this,"Ups");
        inputManager.addListener(this,"Downs");
        inputManager.addListener(this,"Space");
    }
    
    public DirectionalLight getDirectionalLight(){
        return dl;
    }
    
    public AmbientLight getAmbientLight(){
        return am;
    }

    @Override
    public void onAction(String binding, boolean value, float tpf) {
        switch (binding) {
            case "Lefts":
                if(value)
                    left=true;
                else
                    left=false;
                break;
            case "Rights":
                if(value)
                    right=true;
                else
                    right=false;
                break;
            case "Ups":
                if(value)
                    up=true;
                else
                    up=false;
                break;
            case "Downs":
                if(value)
                    down=true;
                else
                    down=false;
                break;
            case "Space":
                player.jump(new Vector3f(0.0f, 1.0f, 0.0f));
                break;
            default:
                break;
        }
    }
}
