package com.company.server_structure.user;

import com.company.data.UserCommunication;
import lombok.Getter;

import java.util.HashMap;
import java.util.UUID;

public class ActiveUsers {

    @Getter private static final HashMap<UUID, UserCommunication> activePlayers = new HashMap<>();

    public static void addPlayer(UUID id, UserCommunication user) {
        activePlayers.put(id, user);
    }

}
