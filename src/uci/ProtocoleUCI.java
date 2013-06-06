package uci;

import chess.Move;
import chess.Position;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Gilles
 */
public class ProtocoleUCI {

    UCIProtocol protocoluci;
    EngineControl controlmoteur;
    SearchParams rechercheparams;
    PrintStream os;
    EngineControl moteur;
    ArrayList<Move> coups;
    Position position;
    boolean quitte;

    public ProtocoleUCI() {
        protocoluci = new UCIProtocol();
        position = protocoluci.pos;
        coups = protocoluci.moves;
        quitte = protocoluci.quit;
//        rechercheparams = new SearchParams();
//        controlmoteur = new EngineControl(os);
//        moteur = protocoluci.engine;

//        moteur.analyseMode; ...
//        position.bKingSq; ...

    }

    final void gererCommande(String cmdLine, PrintStream os) {
        protocoluci.handleCommand(cmdLine, os);
    }

    final public void bouclePrincipale(InputStream is, PrintStream os, boolean autoStart) {
        protocoluci.mainLoop(is, os, autoStart);
    }

    final String[] traiteSymbole(String cmdLine) {
        return protocoluci.tokenize(cmdLine);
    }
}
