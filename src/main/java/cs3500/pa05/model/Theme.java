package cs3500.pa05.model;

import javafx.scene.paint.Color;

/**
 * represents a theme
 */
public enum Theme {

  /**
   * represents a light mode theme
   */
  LIGHT("Light Mode", Color.WHITE, Color.BLACK, "Verdana"),

  /**
   * reprents a dark mode theme
   */
  DARK("Dark Mode", Color.BLACK, Color.WHITE, "Verdana");

  private final String name;
  private final Color backgroundColor;
  private final Color fontColor;
  private final String font;

  Theme(String name, Color backgroundColor, Color fontColor, String font) {
    this.name = name;
    this.backgroundColor = backgroundColor;
    this.fontColor = fontColor;
    this.font = font;
  }

  public String getName() {
    return name;
  }

  public Color getBackgroundColor() {
    return backgroundColor;
  }

  public Color getFontColor() {
    return fontColor;
  }

  public String getFont() {
    return font;
  }
}
