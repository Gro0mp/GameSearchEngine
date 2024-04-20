package com.searchengine;

import java.util.*;

public class UserData {
    private HashSet<Long> UserGames;    // Stores game by ID instead of Game Object to prevent returning owned games
    private HashSet<String> UserTags;   // Stores Hashset of tags in order user most likes
    private HashMap<Long, List<String>> UserInfo; // Dennis - Stores steam game ID and List of Tags

    // empty userdata constructor
    public UserData () 
    {
        this.UserGames = new HashSet<>();
        this.UserTags = new HashSet<>();
        this.UserInfo = new HashMap<>(); // Dennis - Init HashMap
    }

    // Creates user data from list of games
    private UserData (List<Game> UserSelectedGames) 
    {
        this.UserGames = new HashSet<>();
        this.UserTags = new HashSet<>();
        this.UserInfo = new HashMap<>(); // Dennis - Init HashMap
        for (Game game : UserSelectedGames) {
            this.UserGames.add(game.getGameID());
            for (String tag : game.getTags()) {
                this.UserTags.add(tag);
            }
        }
        // Dennis - Store game id's and their associated
        // tags into the hashmap UserInfo.
        for (Game game : UserSelectedGames) {
            UserInfo.put(game.getGameID(), new ArrayList<>(game.getTags()));
        }
    }

    // Creates game list by querying database
    public static UserData CreateUserData (String query) 
    {   
        // asks user for input and adds game if found
        List<Game> GamesList = new ArrayList<>();
        
        while (true) {

            Game game = Database.query(query);
            
            // if game not found output error
            if (game == null) { 
                IOController.ERROR("GAME NOT FOUND"); 
                query = IOController.UserQuery();
                continue; 
            }
            if (game.getGameID() == -1) {  
                break; 
            }
            IOController.GameAdded(game);
            GamesList.add(game);
            query = IOController.UserQuery();
        }

        return new UserData(GamesList);
    }

    // Creates userdata from id list
    public static UserData CreateUserData (List<Long> idList) 
    {
        // gets list of games by ID from database
        List<Game> GamesList = new ArrayList<>();
        for (Long id : idList) {
            if (Database.getGame(id) != null) {
                GamesList.add(Database.getGame(id));
            }
        }

        return new UserData(GamesList);
    }

    void addGame (Game game) 
    {
        UserGames.add(game.getGameID());
        for (String tag : game.getTags()) {
            UserTags.add(tag);
        }
    }  

    public HashSet<Long> getGames() 
    {
        return UserGames;
    }
}