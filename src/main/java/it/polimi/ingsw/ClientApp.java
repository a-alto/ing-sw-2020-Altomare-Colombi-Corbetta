package it.polimi.ingsw;

import it.polimi.ingsw.connection.ConnectionSettings;
import it.polimi.ingsw.connection.client.ClientConnection;
import it.polimi.ingsw.connection.server.ServerConnection;
import it.polimi.ingsw.storage.ResourceManager;
import it.polimi.ingsw.view.clientSide.View;
import it.polimi.ingsw.view.clientSide.viewCore.executers.Executer;
import it.polimi.ingsw.view.clientSide.viewCore.status.ViewStatus;
import it.polimi.ingsw.view.clientSide.viewers.toGUI.GUIViewer;

import java.io.IOException;
import java.util.Scanner;

/**
 * Client-side Application
 *
 * @see <a href="https://github.com/emanueledelsozzo/ingsoft-prova-finale-2020/blob/master/ese_Socket_Serialization/TrisDistributedMVC/src/main/java/it/polimi/ingsw/ClientApp.java">github.com/emanueledelsozzo/.../ClientApp.java</a>
 * @author AndreaAltomare
 */
public class ClientApp {
// todo marked resources folder as Resources root
    /**
     * Start Client-side application.
     *
     * @param args (main() arguments)
     */
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in); // user STDIN [UNIQUE!] reference
        View view;
        ClientConnection client;
        ConnectionSettings connectionSettings;
        final String DEFAULT_IP = "127.0.0.1";
        final int DEFAULT_PORT = 9999; // default port
        String ip = DEFAULT_IP;
        int port = DEFAULT_PORT;

        // TODO: scrivere operazioni di istanziazione della view (magari su un thread diverso), della GUI/CLI, ecc...

        // todo verificare che funzioni con gli argomenti
        // todo verificare che funzioni senza gli argomenti
        // todo verificare che funzioni con i file di configurazione presenti
        // todo verificare che funzioni senza i file di configurazione presenti
        /* Retrieve connection configuration settings */
        if(args.length >= 2) {
            ip = new String(args[0]); // not sure if without "new String(...)" statement i'd get a new reference
            port = Integer.parseInt(args[1]);
        }
        else {
            connectionSettings = ResourceManager.clientConnectionSettings();
            if (connectionSettings != null) {
                ip = connectionSettings.getIp();
                port = connectionSettings.getPort();
            }
        }

        /* Instantiate View and ClientConnection (Connection-Layer) */
        client = new ClientConnection(ip, port);
        view = new View(input, client);
        /* Add observers */ // todo check if this system works (since reading and writing from/to socket is done by threads)
        client.addMVEventsListener(view);
        view.addObserver(client);
        //try {

        //new TerminalViewer().start();
        new GUIViewer().start();
        //new WTerminalViewer().start();
        //new CLIViewer().start();

        Executer.setSender(view);
        ViewStatus.init();

            view.run();


            //client.run();
        //}
        //catch(IOException ex) {
        //    System.err.println(ex.getMessage());
        //}
    }
}
