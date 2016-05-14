package com.example.sam.minesweeperchess;

/**
 * Created by Sam on 4/24/2016.
 */
public class Rook extends Piece {

    public Rook(Board board, PieceColor color, int xPos, int yPos){
        super(board, PieceType.ROOK, color, xPos, yPos);
        if(this.color == color.WHITE)
            this.spriteImageId = R.drawable.white_rook;
        else
            this.spriteImageId = R.drawable.black_rook;
    }

    public boolean canMoveToLocation(int prospectiveX, int prospectiveY) {
        if(!squareIsCandidateMove(prospectiveX, prospectiveY))
            return false;

        if(legalMoveForRook(prospectiveX, prospectiveY)){
            if(!movesThroughPiece(prospectiveX, prospectiveY)){
                    return true;
            }
        }

        return false;
    }

    private boolean movesThroughPiece(int prospectiveX, int prospectiveY){
        int xInc, yInc, xIter, yIter;

        xIter = xPos;
        yIter = yPos;
        int xDiff = prospectiveX - xPos;
        int yDiff = prospectiveY - yPos;
        xInc = xDiff == 0 ? 0 : xDiff/Math.abs(xDiff);
        yInc = yDiff == 0 ? 0 : yDiff/Math.abs(yDiff);

        //iterate through every value between here and there, check if square is occupied
        while(xIter != prospectiveX && yIter != prospectiveY){
            xIter+= xInc;
            yIter+= yInc;

            if(board.squareOccupied(xIter,yIter))
                return true;
        }

        return false;
    }

    //checks if initial square choice is legal for rook without considering other pieces. just check this at the beginnign, run movesThroughPiece, and should be fine
    private boolean legalMoveForRook(int prospectiveX, int prospectiveY){
        return xPos == prospectiveX || yPos == prospectiveY;
    }
}
