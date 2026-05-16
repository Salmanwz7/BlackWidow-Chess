import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.player.ai.*;
import com.chess.gui.Table;

public class BlackWidow {

    public static void main(final String[] args) throws Exception {

        // ===== STAGE 2: Decorator Pattern Demo =====
        final Board board = Board.createStandardBoard();
        final MoveStrategy baseStrategy = new BlackWidowAI(2);
        final MoveStrategy loggedStrategy = new LoggingMoveStrategy(baseStrategy);
        System.out.println("=== Decorator Pattern Demo ===");
        final Move move = loggedStrategy.execute(board);
        System.out.println("=== Decorator Demo Complete ===\n");

        // ===== STAGE 3: Strategy Pattern Demo =====
        System.out.println("=== Strategy Pattern Demo ===");
        final MoveStrategySelector easySelector =
                new MoveStrategySelector(MoveStrategySelector.Difficulty.EASY);
        final MoveStrategy easyStrategy = easySelector.selectStrategy();
        final Move easyMove = easyStrategy.execute(board);
        System.out.println("[STRATEGY] Easy move selected: " + easyMove);

        final MoveStrategySelector hardSelector =
                new MoveStrategySelector(MoveStrategySelector.Difficulty.HARD);
        final MoveStrategy hardStrategy = hardSelector.selectStrategy();
        final Move hardMove = hardStrategy.execute(board);
        System.out.println("[STRATEGY] Hard move selected: " + hardMove);
        System.out.println("=== Strategy Demo Complete ===\n");

        // ===== STAGE 3: Observer Pattern Demo =====
        System.out.println("=== Observer Pattern Demo ===");
        final GameEventNotifier notifier = new GameEventNotifier();
        final MoveHistoryObserver historyObserver = new MoveHistoryObserver();
        final GameStatusObserver statusObserver = new GameStatusObserver();

        notifier.addObserver(historyObserver);
        notifier.addObserver(statusObserver);

        notifier.notifyObservers("MOVE_MADE", "e2-e4");
        notifier.notifyObservers("MOVE_MADE", "e7-e5");
        notifier.notifyObservers("MOVE_MADE", "g1-f3");
        notifier.notifyObservers("GAME_OVER", "White wins by checkmate");

        historyObserver.printHistory();
        System.out.println("[STATUS] Final status: "
                + statusObserver.getCurrentStatus());
        System.out.println("[STATUS] Total moves: "
                + statusObserver.getTotalMoves());
        System.out.println("=== Observer Demo Complete ===\n");

        // Launch GUI
        Table.get().show();
    }
}