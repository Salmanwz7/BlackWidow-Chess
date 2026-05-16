package com.chess.engine.player.ai;

public class GameStatusObserver implements GameObserver {

    private String currentStatus;
    private int totalMoves;

    public GameStatusObserver() {
        this.currentStatus = "GAME_STARTED";
        this.totalMoves = 0;
    }

    @Override
    public void onGameEvent(final String eventType, final String eventData) {
        switch (eventType) {
            case "MOVE_MADE":
                this.totalMoves++;
                this.currentStatus = "IN_PROGRESS";
                System.out.println("[GAME STATUS OBSERVER] Move #" + totalMoves
                        + " made. Status: " + currentStatus);
                break;
            case "GAME_OVER":
                this.currentStatus = "GAME_OVER";
                System.out.println("[GAME STATUS OBSERVER] Game over! Result: "
                        + eventData + " | Total moves: " + totalMoves);
                break;
            case "NEW_GAME":
                this.totalMoves = 0;
                this.currentStatus = "GAME_STARTED";
                System.out.println("[GAME STATUS OBSERVER] New game started.");
                break;
            default:
                break;
        }
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public int getTotalMoves() {
        return this.totalMoves;
    }
}