package com.chess.engine.player.ai;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public class LoggingMoveStrategy implements MoveStrategy {

    private final MoveStrategy decoratedStrategy;

    public LoggingMoveStrategy(final MoveStrategy strategy) {
        this.decoratedStrategy = strategy;
    }

    @Override
    public long getNumBoardsEvaluated() {
        return this.decoratedStrategy.getNumBoardsEvaluated();
    }

    @Override
    public Move execute(final Board board) {
        System.out.println("[LOG] AI strategy started: " + this.decoratedStrategy.getClass().getSimpleName());
        final long startTime = System.currentTimeMillis();
        final Move bestMove = this.decoratedStrategy.execute(board);
        final long endTime = System.currentTimeMillis();
        System.out.println("[LOG] AI strategy finished in " + (endTime - startTime) + " ms");
        System.out.println("[LOG] Boards evaluated: " + this.decoratedStrategy.getNumBoardsEvaluated());
        System.out.println("[LOG] Best move selected: " + bestMove);
        return bestMove;
    }
}