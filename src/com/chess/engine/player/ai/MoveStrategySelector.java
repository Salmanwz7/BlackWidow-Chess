package com.chess.engine.player.ai;

public class MoveStrategySelector {

    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    private Difficulty difficulty;

    public MoveStrategySelector(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public MoveStrategy selectStrategy() {
        switch (this.difficulty) {
            case EASY:
                System.out.println("[STRATEGY] Difficulty: EASY — using MiniMax depth 1");
                return new MiniMax(1);
            case MEDIUM:
                System.out.println("[STRATEGY] Difficulty: MEDIUM — using BlackWidowAI depth 2");
                return new BlackWidowAI(2);
            case HARD:
                System.out.println("[STRATEGY] Difficulty: HARD — using BlackWidowAI depth 4");
                return new BlackWidowAI(4);
            default:
                return new BlackWidowAI(2);
        }
    }
}