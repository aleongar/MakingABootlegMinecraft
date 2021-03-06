package com.mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;


/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    World w;
    Player mainPlayer;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        w = new World(assetManager);
        mainPlayer = new Player(stateManager, flyCam, inputManager, cam);
        rootNode.addLight(mainPlayer.getDirectionalLight()); 
        rootNode.addLight(mainPlayer.getAmbientLight());
        rootNode.attachChild(w);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}

    