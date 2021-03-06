package com.company.libgdx.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import lombok.Getter;

public class Styles {

    @Getter private static final TextButton.TextButtonStyle buttonStyle;
    @Getter private static final Label.LabelStyle labelStyle;
    @Getter private static final TextField.TextFieldStyle textInputStyle;

    static {
         buttonStyle = new TextButton.TextButtonStyle();
         buttonStyle.font = new BitmapFont();

         labelStyle = new Label.LabelStyle();
         labelStyle.font = new BitmapFont();

         textInputStyle = new TextField.TextFieldStyle();
         textInputStyle.fontColor = Color.WHITE;
         textInputStyle.font = new BitmapFont();

        // getting cursor for text field
        Label oneCharSizeCalibrationThrowAway = new Label("|", Styles.getLabelStyle());
        Pixmap cursorColor = new Pixmap((int) oneCharSizeCalibrationThrowAway.getWidth(),
                (int) new TextField("",Styles.getTextInputStyle()).getHeight(),
                Pixmap.Format.RGB888);
        cursorColor.setColor(com.badlogic.gdx.graphics.Color.WHITE);
        cursorColor.fill();
        textInputStyle.cursor = new Image(new Texture(cursorColor)).getDrawable();
    }

}
