package it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.skeleton;

import it.polimi.ingsw.view.clientSide.View;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.elements.PanelImageButton;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.utilities.SubPanel;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.sounds.SoundEffect;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TitlePanel extends SubPanel {

    static final int minH = 20;

    private BufferedImage title;

    private PanelImageButton soundButton;
    private PanelImageButton undoButton;

    public void init(){
        Dimension minDim = getParent().getMinimumSize();
        try {
            title = ImageIO.read(getClass().getResource("/img/logo/Santorini.png"));
        } catch (IOException e) {
            if(View.debugging)
                e.printStackTrace();
            return;
        }
        Dimension newMinDim = new Dimension(
                (int) (minDim.getWidth() + minH * (((double) title.getWidth())/title.getHeight())),
                (int) (minDim.getHeight() + minH)
        );
        this.getParent().setMinimumSize(newMinDim);
    }


    public TitlePanel() {
        super(1, 0.2, 0, 0);
        this.setOpaque(false);

        JButton soundRealButton = new JButton();
        soundRealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SoundEffect.setEnabled(!SoundEffect.getEnabled());
                if(SoundEffect.getEnabled())
                    soundButton.setBackgroundImg("/img/trappings/speaker.png", "sound on");
                else
                    soundButton.setBackgroundImg("/img/trappings/noSound.png", "mute");
            }
        });

        soundButton = new PanelImageButton(0.1, 0.4, 0.85, 0.1, soundRealButton, "/img/trappings/speaker.png", "sound");
        if(SoundEffect.getEnabled())
            soundButton.setBackgroundImg("/img/trappings/speaker.png", "sound on");
        else
            soundButton.setBackgroundImg("/img/trappings/noSound.png", "mute");
        add(soundButton);
    }

    public TitlePanel(JPanel parent) {
        this();

        parent.add(this);

        init();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension panelDimension = getSize();
        Dimension titleDimension = new Dimension(
                (int) (panelDimension.getHeight() *(((double) title.getWidth())/title.getHeight())),
                (int) panelDimension.getHeight()
        );
        g.drawImage(title, (int)((panelDimension.getWidth() - titleDimension.getWidth())/2), 0, (int)titleDimension.getWidth(), (int)titleDimension.getHeight(), this);

    }


}
