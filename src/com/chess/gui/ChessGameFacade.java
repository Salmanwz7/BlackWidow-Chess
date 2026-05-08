package com.chess.gui;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.gui.Table.MoveLog;

public class ChessGameFacade {

    private final GameHistoryPanel gameHistoryPanel;
    private final TakenPiecesPanel takenPiecesPanel;
    private final DebugPanel debugPanel;
    private final MoveLog moveLog;

    public ChessGameFacade(final GameHistoryPanel gameHistoryPanel,
                           final TakenPiecesPanel takenPiecesPanel,
                           final DebugPanel debugPanel,
                           final MoveLog moveLog) {
        this.gameHistoryPanel = gameHistoryPanel;
        this.takenPiecesPanel = takenPiecesPanel;
        this.debugPanel = debugPanel;
        this.moveLog = moveLog;
    }

    public void addMove(final Move move) {
        this.moveLog.addMove(move);
    }

    public void refreshDisplay(final Board board) {
        this.gameHistoryPanel.redo(board, this.moveLog);
        this.takenPiecesPanel.redo(this.moveLog);
        this.debugPanel.redo();
    }

    public void clearAndReset(final Board board) {
        this.moveLog.clear();
        this.gameHistoryPanel.redo(board, this.moveLog);
        this.takenPiecesPanel.redo(this.moveLog);
        this.debugPanel.redo();
    }

    public MoveLog getMoveLog() {
        return this.moveLog;
    }
}