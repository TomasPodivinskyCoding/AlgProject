package com.company.libgdx.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.company.communication_protocol.user.UserCommunicationProtocol;
import com.company.libgdx.screens.screens.GameScreen;
import com.company.libgdx.util.BodyHelper;
import com.company.libgdx.util.ContactType;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Enemy implements GameObject {

    private final Body body;

    @Getter private float angle;

    @Getter private float x;
    @Getter private float y;

    final float PLAYER_SIZE = 30;

    private final BufferedReader reader;

    GameScreen gameScreen;

    private final static float DEFAULT_SPAWN_POINT = 150;

    private final Texture texture;
    public Enemy(float x, float y, float angle, GameScreen gameScreen){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.reader = UserCommunicationProtocol.getInputStream();
        this.texture = new Texture("white.png");
        this.gameScreen = gameScreen;
        this.body = BodyHelper.createBody(x, y, PLAYER_SIZE, PLAYER_SIZE, false
                , 10000, gameScreen.getWorld(), ContactType.PLAYER);
    }

    @Override
    public void update() {
        System.out.println("1");
        try {
            String[] newPositions = reader.readLine().split(" ");
            System.out.println(Arrays.toString(newPositions));
            this.x = Float.parseFloat(newPositions[0]);
            this.y = Float.parseFloat(newPositions[1]);
            this.angle = Float.parseFloat(newPositions[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, PLAYER_SIZE / 2, PLAYER_SIZE / 2, PLAYER_SIZE, PLAYER_SIZE, 1f, 1f, angle, 0, 0, 32, 32, false, false);
    }

}
