package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GameRoom extends GeneralGameRoom {
    public GameRoom() {
        players = new ArrayList<Player>();
        // TODO: add abstract game box istances
    }

    // Player list manipulation

    /**
     * Add a player to the players list
     *
     * @param nickname (Player's nickname)
     */
    @Override
    public boolean addPlayer(String nickname) {
        return players.add(new Player(nickname));
    }

    /**
     * Remove a player from the players list
     *
     * @param nickname (Player's nickname)
     */
    @Override
    public void removePlayer(String nickname) {
        Player toRemove;

        toRemove = getPlayerReference(nickname);
        if(toRemove != null)
            players.remove(toRemove);
    }

    /**
     * Give access to the whole players list
     * by using an iterator object
     *
     * @return players.iterator()
     */
    @Override
    public Iterator<Player> getPlayers() {
        return players.iterator();
    }

    // Game settings
    @Override
    public void setupGame() {
        // TODO: add game setup operations
    }

    /**
     * Set the Challenger player for this game
     *
     * @param nickname (Player's nickname)
     */
    @Override
    public void chooseChallenger(String nickname) {
        Player player;

        player = getPlayerReference(nickname);
        if(player != null)
            player.setChallenger(true);
    }

    /**
     * Set the Starting player for this game
     *
     * @param nickname (Player's nickname)
     */
    @Override
    public void chooseStartingPlayer(String nickname) {
        Player player;

        player = getPlayerReference(nickname);
        if(player != null)
            player.setStartingPlayer(true);
    }

    // TODO: maybe useless method, to remove
    /**
     * Given an index, this method returns a reference to
     * a Player object
     *
     * @param n (index of the player)
     * @return Player object reference
     */
    @Override
    public Player getPlayer(int n) {
        return players.get(n);
    }

    /**
     *
     * @return a reference to the challenger Player
     */
    @Override
    public Player getChallenger() {
        for(Player obj : players)
            if(obj.isChallenger())
                return obj;

        return null;
    }

    /**
     *
     * @return a reference to the starting Player
     */
    @Override
    public Player getStartingPlayer() {
        for(Player obj : players)
            if(obj.isStartingPlayer())
                return obj;

        return null;
    }

    /**
     * Given a nickname, this method returns a reference to
     * the Player object with that unique nickname (key)
     *
     * @param nickname (Player's nickname)
     * @return Player object reference
     */
    private Player getPlayerReference(String nickname) {
        for(Player obj : players) {
            if(obj.getNickname().equals(nickname))
                return obj;
        }
        return null;
    }

    /**
     * This method is called when the Cards assignment is over:
     * Cards whose power is active on opponents turn, must be
     * registered as Turn Observers in their respective Turn Managers
     */
    private void registerObservers() {
        /* 1- Take all the AdversaryMove objects */ // TODO: Check if Lambda expression works fine
        List<Player> selectedPlayers = players.stream().filter(x -> x.getCard().getGodPower().isActiveOnOpponentMovement()).collect(Collectors.toList());

        /* 2- Get all the AdversaryMove object */
        List<AdversaryMove> adversaryMoveObservers = new ArrayList<>();
        for(Player playerObj : selectedPlayers)
            adversaryMoveObservers.add(playerObj.getCard().getAdversaryMove());

        /* 3- Create MovementObserver objects from AdversaryMove ones */
        List<MovementObserver> movementObservers = new ArrayList<>();
        for(AdversaryMove adversaryMoveObj : adversaryMoveObservers)
            movementObservers.add(new MovementObserver(adversaryMoveObj));

        /* 4- Register each AdversaryMove element in every Player's appropriate Turn Observer */
        for(MovementObserver movementObs : movementObservers)
            for(Player playerObj : players)
                playerObj.getMovementManager().registerObservers(movementObs);
    }
}
