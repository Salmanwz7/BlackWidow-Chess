package com.chess.engine.player.ai;

import java.util.ArrayList;
import java.util.List;

public class MoveHistoryObserver implements GameObserver {

    private final List<String> moveHistory;

    public MoveHistoryObserver() {
        this.moveHistory = new ArrayList<>();
    }

    @Override
    public void onGameEvent(final String eventType, final String eventData) {
        if (eventType.equals("MOVE_MADE")) {
            this.moveHistory.add(eventData);
            System.out.println("[MOVE HISTORY OBSERVER] Move recorded: " + eventData);
        }
    }

    public List<String> getMoveHistory() {
        return this.moveHistory;
    }

    public void printHistory() {
        System.out.println("[MOVE HISTORY OBSERVER] Full move history:");
        for (int i = 0; i < moveHistory.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + moveHistory.get(i));
        }
    }
}