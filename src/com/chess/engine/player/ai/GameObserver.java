package com.chess.engine.player.ai;

public interface GameObserver {
    void onGameEvent(String eventType, String eventData);
}