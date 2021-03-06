package it.polimi.ingsw.view.clientSide.viewers.toGUI.subTurnClasses;

import it.polimi.ingsw.view.clientSide.viewers.interfaces.SubTurnViewer;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.gamePanel.board.boardSubTurn.BoardSubTurn;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.gamePanel.board.boardSubTurn.specific.ForbiddenBoardSubTurn;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.helperPanels.gamePanel.board.subTurnPanel.SelectCardPanel;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.interfaces.GUISubTurnViewer;

import javax.swing.*;

/**
 * Class extending <code>GUISubTurnViewer</code> representing the SELECTCARD <code>ViewSubTurn</code>.
 */
public class SelectCardSubTurn extends GUISubTurnViewer {

    /**
     * constructor.
     *
     * @param parent (the <code>SubTurnViewer</code> to which this refers to).
     */
    public SelectCardSubTurn(SubTurnViewer parent){
        super(parent);
    }

    /**
     * Method that returns the subTurnPanel relatives to the SELECTCARD subTurn.
     *
     * @return (the <code>JPanel</code> relative to the SELECTCARD subTurn).
     */
    @Override
    public JPanel getSubTurnPanel(){
        return new SelectCardPanel();
    }

    /**
     * Method that returns the BoardSubTurn referring to SELECTCARD.
     *
     * @return (the <code>getBoardSubTurn</code> that refers to the SELECTCARD subTurn).
     */
    @Override
    public BoardSubTurn getBoardSubTurn(){
        return new ForbiddenBoardSubTurn(this);
    }
}
