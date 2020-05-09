package it.polimi.ingsw.view.clientSide.viewers.statusViewers;

import it.polimi.ingsw.view.clientSide.viewCore.executers.Executer;
import it.polimi.ingsw.view.clientSide.viewers.interfaces.StatusViewer;
import it.polimi.ingsw.view.clientSide.viewers.toCLI.interfaces.CLIStatusViewer;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.interfaces.GUIStatusViewer;
import it.polimi.ingsw.view.clientSide.viewers.toTerminal.interfaces.TerminalStatusViewer;
import it.polimi.ingsw.view.clientSide.viewers.toTerminal.statusClasses.TerminalReadyStatus;

import java.util.Map;

public class ReadyViewer implements StatusViewer {

    Map<String, Executer> myExecuters;

    public ReadyViewer(Map<String, Executer> executers){
        myExecuters = executers;
    }

    @Override
    public TerminalStatusViewer toTerminal() {
        return new TerminalReadyStatus(this);
    }

    @Override
    public GUIStatusViewer toGUI() {
        return null;
    }

    @Override
    public CLIStatusViewer toCLI() {
        return null;
    }
}