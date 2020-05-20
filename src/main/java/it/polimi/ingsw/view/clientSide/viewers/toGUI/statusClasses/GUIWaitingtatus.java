package it.polimi.ingsw.view.clientSide.viewers.toGUI.statusClasses;

import it.polimi.ingsw.view.clientSide.viewers.interfaces.StatusViewer;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.skeleton.TitlePanel;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.utilities.BackgroundPanel;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.interfaces.GUIStatusViewer;

import javax.swing.*;

public class GUIWaitingtatus extends GUIStatusViewer {

    StatusViewer myStatusViewer;
    public GUIWaitingtatus(StatusViewer statusViewer){ myStatusViewer = statusViewer; }

    @Override
    public boolean hasJPanel(){ return true; }

    @Override
    public JPanel getJPanel(){
        JPanel panel = new BackgroundPanel("/img/background/sized_waiting_background.png");
        new TitlePanel(panel);
        return panel;
    }
}
