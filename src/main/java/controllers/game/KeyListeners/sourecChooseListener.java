package controllers.game.KeyListeners;

import card.Card;
import card.Energy;
import card.Pokemon;
import controllers.card.PokemonController;
import controllers.game.GameController;
import views.activepokemon.ActivePokemonView;
import views.card.PokemonView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by zc on 2017/7/23.
 */
public class sourecChooseListener implements KeyListener {
    private GameController controller;
    private Card card;
    private PokemonController sourceController;


    public sourecChooseListener(GameController controller, Card card) {
        this.controller = controller;
        this.card = card;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER: {
                controller.getView().setCommand("s from sourecChooseListener\n(Press Esc to exit)");

                PokemonView chosenCard = (PokemonView) SwingUtilities.getAncestorOfClass(PokemonView.class, (Component) e.getSource());
                PokemonController chosenController;

                if (SwingUtilities.getAncestorOfClass(ActivePokemonView.class, (Component) e.getSource()) != null) {
                    sourceController = controller.getHumanController().
                            getActivePokemonController().getPokemonController();
                } else {
                    sourceController = (PokemonController) controller.findCardInContainer(
                            chosenCard, controller.getHumanController().getBenchController());
                }
//                controller.getHumanController().setSourceController(sourceController);
                break;
            }

            default: {
                System.out.println("Enter the correct Key.(from sourecChooseListener)");
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
