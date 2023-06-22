package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * Represents a GUI view for a bullet journal.
 */
public interface BujoView {
  /**
   * Loads a scene from a bullet journal GUI layout.
   *
   * @return the layout
   * @throws IllegalStateException it there's an error loading
   */
  Scene load() throws IllegalStateException;
}
