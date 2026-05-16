package com.chess.engine.player.ai;

import java.util.ArrayList;
import java.util.List;

public class GameEventNotifier {

    private final List<GameObserver> observers;

    public GameEventNotifier() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(final GameObserver observer) {
        this.observers.add(observer);
        System.out.println("[NOTIFIER] Observer registered: "
                + observer.getClass().getSimpleName());
    }

    public void removeObserver(final GameObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers(final String eventType, final String eventData) {
        System.out.println("[NOTIFIER] Broadcasting event: " + eventType
                + " | Data: " + eventData);
        for (final GameObserver observer : this.observers) {
            observer.onGameEvent(eventType, eventData);
        }
    }
}