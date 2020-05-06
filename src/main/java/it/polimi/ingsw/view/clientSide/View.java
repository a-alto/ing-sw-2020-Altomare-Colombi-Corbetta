package it.polimi.ingsw.view.clientSide;

import it.polimi.ingsw.controller.events.*;
import it.polimi.ingsw.observer.MVEventListener;
import it.polimi.ingsw.observer.Observable;
import it.polimi.ingsw.view.clientSide.viewCore.executers.Executer;
import it.polimi.ingsw.view.clientSide.viewCore.executers.executerClasses.BuildBlockExecuter;
import it.polimi.ingsw.view.clientSide.viewCore.status.ViewStatus;
import it.polimi.ingsw.view.clientSide.viewers.interfaces.Viewer;
import it.polimi.ingsw.view.clientSide.viewers.toCLI.CLIViewer;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.GUIViewer;
import it.polimi.ingsw.view.clientSide.viewers.toTerminal.TerminalViewer;
import it.polimi.ingsw.view.events.BuildBlockEvent;
import it.polimi.ingsw.view.serverSide.ClientStatus;

public class View extends Observable<Object> implements MVEventListener { // todo: maybe this class extends Observable<Object> for proper interaction with Network Handler

    /* Server general listener */
    @Override
    public void update(ClientStatus clientStatus) {}

    @Override
    public void update(NextStatusEvent nextStatus) {}

    @Override
    public void update(ServerSendDataEvent serverSentData) {}

    @Override
    public void update(InvalidNicknameEvent invalidNickname) {}

    @Override
    public void update(RequirePlayersNumberEvent requirePlayersNumber) {}

    @Override
    public void update(LobbyFullEvent lobbyFull) {}

    @Override
    public void update(PlayerWinEvent playerWin) {}

    @Override
    public void update(PlayerLoseEvent playerLose) {}

    @Override
    public void update(TurnStatusChangedEvent turnStatusChange) {}


    /* Game preparation listener */
    @Override
    public void update(WorkerPlacedEvent workerPlaced) {}

    @Override
    public void update(CardSelectedEvent cardSelected) {}


    /* Move executed listener */
    @Override
    public void update(WorkerMovedEvent workerMoved) {}

    @Override
    public void update(BlockBuiltEvent blockBuilt) {}

    @Override
    public void update(WorkerRemovedEvent workerRemoved) {}

    @Override
    public void update(BlockRemovedEvent blockRemoved) {}

    @Override
    public void update(WorkerSelectedEvent workerSelected) {}


    /* Message listener */
    @Override
    public void update(MessageEvent message) {}


    /* Error message listener */
    @Override
    public void update(ErrorMessageEvent message) {}


    /* Generic update method */
    @Override
    public void update(Object o) {}



    public static void main(String[] args) {
        new TerminalViewer();
        new CLIViewer();
        new GUIViewer();
        System.out.println("Hello World");

        ViewStatus.init();
        Viewer.setAllStatusViewer(ViewStatus.getActual().getViewer());

        ViewStatus.nextStatus();
        Viewer.setAllStatusViewer(ViewStatus.getActual().getViewer());

    }
}
