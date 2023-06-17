package cs3500.pa05.view;

import javafx.scene.Scene;

/**
 * Represents a GUI view for a bullet journal.
 */
public interface BojuView {
  /**
   * Loads a scene from a bullet journal GUI layout.
   *
   * @return the layout
   */
  Scene load() throws IllegalStateException;
}
