package nl.tue.s2id90.group01;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;  
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.draughts.player.DraughtsPlayer;
import org10x10.dam.game.DamConstants;
import org10x10.dam.game.Move;

/**
 * Implementation of the DraughtsPlayer interface.
 * @author huub
 */
// ToDo: rename this class (and hence this file) to have a distinct name
//       for your player during the tournament
public class MyDraughtsPlayer  extends DraughtsPlayer{
    private int bestValue=0;
    int maxSearchDepth;
    /** boolean that indicates that the GUI asked the player to stop thinking. */
    private boolean stopped;

    public MyDraughtsPlayer(int maxSearchDepth) {
        super("best.png"); // ToDo: replace with your own icon
        this.maxSearchDepth = maxSearchDepth;
    }
    
    @Override public Move getMove(DraughtsState s) {
        Move bestMove = null;
        bestValue = 0;
        DraughtsState temp_state = s.clone();
        DraughtsNode node = new DraughtsNode(s);    // the root of the search tree
        int temp_depth = maxSearchDepth;
        
        //DEBUG
        tempi(transformField(s.getPieces()));
        
        try {
            //Iterative deepening
            while(stopped == false){
                // compute bestMove and bestValue in a call to alphabeta
                bestValue = alphaBeta(node, MIN_VALUE, MAX_VALUE, temp_depth);

                // store the bestMove found uptill now
                // NB this is not done in case of an AIStoppedException in alphaBeat()
                bestMove  = node.getBestMove();

                // print the results for debugging reasons
                /*System.err.format(
                    "%s: depth= %2d, best move = %5s, value=%d\n", 
                    this.getClass().getSimpleName(),temp_depth, bestMove, bestValue
                );*/
                temp_depth++;
            }
        } catch (AIStoppedException ex) {  /* nothing to do */  }
        
        if (bestMove==null) {
            System.err.println("no valid move found!");
            return getRandomValidMove(temp_state);
        } else {
            return bestMove;
        }
    } 

    /** This method's return value is displayed in the AICompetition GUI.
     * 
     * @return the value for the draughts state s as it is computed in a call to getMove(s). 
     */
    @Override public Integer getValue() { 
       return bestValue;
    }

    /** Tries to make alphabeta search stop. Search should be implemented such that it
     * throws an AIStoppedException when boolean stopped is set to true;
    **/
    @Override public void stop() {
       stopped = true; 
    }
    
    /** returns random valid move in state s, or null if no moves exist. */
    Move getRandomValidMove(DraughtsState s) {
        List<Move> moves = s.getMoves();
        Collections.shuffle(moves);
        //System.out.println(s);
        return moves.isEmpty()? null : moves.get(0);
    }
    
    /** Implementation of alphabeta that automatically chooses the white player
     *  as maximizing player and the black player as minimizing player.
     * @param node contains DraughtsState and has field to which the best move can be assigned.
     * @param alpha
     * @param beta
     * @param depth maximum recursion Depth
     * @return the computed value of this node
     * @throws AIStoppedException
     **/
    int alphaBeta(DraughtsNode node, int alpha, int beta, int depth)
            throws AIStoppedException
    {
        if (node.getState().isWhiteToMove()) {
            return alphaBetaMax(node, alpha, beta, depth);
        } else  {
            return alphaBetaMin(node, alpha, beta, depth);
        }
    }
    
    /** Does an alphabeta computation with the given alpha and beta
     * where the player that is to move in node is the minimizing player.
     * 
     * <p>Typical pieces of code used in this method are:
     *     <ul> <li><code>DraughtsState state = node.getState()</code>.</li>
     *          <li><code> state.doMove(move); .... ; state.undoMove(move);</code></li>
     *          <li><code>node.setBestMove(bestMove);</code></li>
     *          <li><code>if(stopped) { stopped=false; throw new AIStoppedException(); }</code></li>
     *     </ul>
     * </p>
     * @param node contains DraughtsState and has field to which the best move can be assigned.
     * @param alpha
     * @param beta
     * @param depth  maximum recursion Depth
     * @return the compute value of this node
     * @throws AIStoppedException thrown whenever the boolean stopped has been set to true.
     */
     int alphaBetaMin(DraughtsNode node, int alpha, int beta, int depth)
            throws AIStoppedException {
        if (stopped) { stopped = false; throw new AIStoppedException(); }
        DraughtsState state = node.getState();
         
        //----------------------------------------//
        //- Own code -----------------------------//
        //----------------------------------------//
        //If at a leaf
        if(depth == 0){
            return evaluate(state);
        }
        //Set initial return to infinity
        int value = Integer.MAX_VALUE;

        //Process new moves        
        int move_number = state.getMoves().size();
        //System.out.println("mvn= " + move_number + "  depth= " + depth);
        for (int x = 0; x < move_number; x++){
            //System.out.println("x= " + x);
            //System.out.println(state.getMoves().get(x));
            Move m = state.getMoves().get(x);
            state.doMove(m);
            
            value = alphaBetaMax(new DraughtsNode(state), alpha, beta, depth - 1);
            
            state.undoMove(m);
            
            if(value < beta){
                beta = value;
                if(depth == maxSearchDepth){
                    Move bestMove = state.getMoves().get(x);
                    node.setBestMove(bestMove);
                    //System.out.println(bestMove);
                }
            }
            
            
            
            if (beta <= alpha){
                break;
            }
        }       
        
        //========================================//
//        System.out.println(node.getBestMove());
        return value;
     }
    
    int alphaBetaMax(DraughtsNode node, int alpha, int beta, int depth)
            throws AIStoppedException {
        if (stopped) { stopped = false; throw new AIStoppedException(); }
        DraughtsState state = node.getState();
        //System.out.println("nl.tue.s2id90.group01.MyDraughtsPlayer.alphaBetaMax()");
        
//        System.out.println(alpha + " " + beta + " " + depth);
        //----------------------------------------//
        //- Own code -----------------------------//
        //----------------------------------------//
        //If at a leaf
        if(depth == 0){
            return evaluate(state);
        }
        //Set initial return to infinity
        int value = Integer.MAX_VALUE;

        //Process new moves        
        int move_number = state.getMoves().size();
        //System.out.println("mvn= " + move_number + "  depth= " + depth);
        for (int x = 0; x < move_number; x++){
            //System.out.println("x= " + x);
            //System.out.println(state.getMoves().get(x));
            Move m = state.getMoves().get(x);
            state.doMove(m);
            
            value = alphaBetaMin(new DraughtsNode(state), alpha, beta, depth - 1);
            
            state.undoMove(m);
            
            if(value > alpha){
                alpha = value;
                
                if(depth == maxSearchDepth){
                    Move bestMove = state.getMoves().get(x);
                    node.setBestMove(bestMove);
                    //System.out.println(bestMove);
                }
            }
            
            if (beta <= alpha){
                break;
            }
        }       
        //========================================//
        //Move bestMove = state.getMoves().get(0);
        //node.setBestMove(bestMove);
//        System.out.println(node.getBestMove());
        return value;
    }

    /** A method that evaluates the given state. */
    int evaluate(DraughtsState state) { 
        int score = 0;
        //Get array of pieces
        int[] pieces = state.getPieces();
        int[][] field = transformField(pieces);
        //Count piece worths of both players and take the difference as the score
        //Man = 3 points, King = 5 points
        for(int x = 0; x < pieces.length; x++){
            if(pieces[x] == state.BLACKPIECE){
                score -= 15;
            }
            if(pieces[x] == state.BLACKKING){
                score -= 25;
            }
            if(pieces[x] == state.WHITEPIECE){
                score += 15;
            }
            if(pieces[x] == state.WHITEKING){
                score += 25;
            }
        }
        
        score += clusterScore(state);
        

        return score; 
    }
    
    int tempi(int[][] field){
        int tempi = 0;
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                if(field[x][y] == DraughtsState.BLACKPIECE){
                    tempi -= y;
                }
                if(field[x][y] == DraughtsState.WHITEPIECE){
                    tempi += 9-y;
                }
            }
            
        }
               
        System.out.println(tempi);
        return tempi;
    }
    
    int clusterScore(DraughtsState s){
        boolean b = false, w = false;
        int[][] field = transformField(s.getPieces());
        
        int score = 0;
        
        ArrayList<int[]> ads = null; // All Adjacent squares of a place
        int odd = 1;
        int place = -1;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 5; j++){
                
                place = field[i][(j*2)+odd];
                ads = adjacentPlaces((j*2)+odd, i); // Get adjacent squares of place and check for surrounding squares with same color
                
                if(isBlack(place)){
                    boolean blacks = false;
                    for(int q = 0 ; q < ads.size(); q++){
                        if(isBlack(field[ads.get(q)[1]][ads.get(q)[0]])){
                            blacks = true;
                        }
                    }
                    if(!blacks){
                        score += 1;
                    }
                }
                if(isWhite(place)){
                    boolean whites = false;
                    for(int q = 0 ; q < ads.size(); q++){
                        if(isWhite(field[ads.get(q)[1]][ads.get(q)[0]])){
                            whites = true;
                        }
                    }
                    if(!whites){
                        score -= 1;
                    }
                }
                
            }
            
            if(odd == 1){
                odd = 0;
            }else{
                odd = 1;
            }
        }
        
        return score;
    }
    
    boolean isWhite(int q){
        return q == DraughtsState.WHITEKING || q == DraughtsState.WHITEPIECE;
    }
    
    boolean isBlack(int q){
        return q == DraughtsState.BLACKKING || q == DraughtsState.BLACKPIECE;
    }
    
    int[][] transformField(int[] initF){
        int[][] resultField = new int[10][10];
        int odd = 1;
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 5; j++){
                resultField[i][(j*2)+odd] = initF[(i*5) + j];
            }
            
            if(odd == 1){
                odd = 0;
            }else{
                odd = 1;
            }
        }
        
        return resultField;
    }
    
    ArrayList<int[]> adjacentPlaces(int x, int y){
        ArrayList<int[]> r = new ArrayList<int[]>();
        
        if(isInBound(x-1, y-1)){
            r.add(new int[]{x-1,y-1});
        }
        if(isInBound(x+1, y-1)){
            r.add(new int[]{x+1,y-1});
        }
        if(isInBound(x-1, y+1)){
            r.add(new int[]{x-1,y+1});
        }
        if(isInBound(x+1, y+1)){
            r.add(new int[]{x+1,y+1});
        }
        return r;
    }
    
    boolean isInBound(int i, int j){
        return i >= 0 && i < 10 && j >= 0 && j < 10;
    }
}
