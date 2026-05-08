import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.player.ai.BlackWidowAI;
import com.chess.engine.player.ai.LoggingMoveStrategy;
import com.chess.engine.player.ai.MoveStrategy;
import com.chess.gui.Table;

public class BlackWidow {

    public static void main(final String[] args) throws Exception {
        // Demonstrate Decorator Pattern
        final Board board = Board.createStandardBoard();
        final MoveStrategy baseStrategy = new BlackWidowAI(2);
        final MoveStrategy loggedStrategy = new LoggingMoveStrategy(baseStrategy);
        System.out.println("=== Decorator Pattern Demo ===");
        final Move move = loggedStrategy.execute(board);
        System.out.println("=== Demo Complete ===");

        // Launch GUI as normal
        Table.get().show();
    }
}