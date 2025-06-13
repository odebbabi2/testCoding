package com.astrelya.kata.bank;

import java.util.*;

public class Bank implements IBank {

    private final Map<String, IClient> clients = new HashMap<>();

    @Override
    public void register(IClient client) {
        if (clients.containsKey(client.getEmail())) {
            throw new IllegalArgumentException("Client " + client.getEmail() + " already exist");
        }
        clients.put(client.getEmail(), client);
    }

    public void addClient(Client client) {
        register(client);
    }

    public Optional<Client> searchClient(String email) {
        IClient client = clients.get(email);
        if (client instanceof Client) {
            return Optional.of((Client) client);
        }
        return Optional.empty();
    }

    public List<IClient> getClientList() {
        return new ArrayList<>(clients.values());
    }
}
