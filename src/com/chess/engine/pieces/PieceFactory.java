package com.chess.engine.pieces;

import com.chess.engine.Alliance;

public class PieceFactory {

    private static PieceFactory instance;

    private PieceFactory() {}

    public static PieceFactory getInstance() {
        if (instance == null) {
            instance = new PieceFactory();
        }
        return instance;
    }

    public Piece createPiece(final String pieceType,
                             final Alliance alliance,
                             final int position,
                             final boolean isFirstMove) {
        switch (pieceType.toUpperCase()) {
            case "PAWN":   return PieceUtils.INSTANCE.getPawn(alliance, position, isFirstMove);
            case "KNIGHT": return PieceUtils.INSTANCE.getKnight(alliance, position, isFirstMove);
            case "BISHOP": return PieceUtils.INSTANCE.getBishop(alliance, position, isFirstMove);
            case "ROOK":   return PieceUtils.INSTANCE.getRook(alliance, position, isFirstMove);
            case "QUEEN":  return PieceUtils.INSTANCE.getQueen(alliance, position, isFirstMove);
            case "KING":   return new King(alliance, position, true, true);
            default: throw new IllegalArgumentException("Unknown piece type: " + pieceType);
        }
    }
}