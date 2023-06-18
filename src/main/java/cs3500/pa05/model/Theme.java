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

  /**
   * constructor for theme
   *
   * @param name of theme
   * @param backgroundColor color of background
   * @param fontColor color of font
   * @param font font style
   */
  Theme(String name, Color backgroundColor, Color fontColor, String font) {
    this.name = name;
    this.backgroundColor = backgroundColor;
    this.fontColor = fontColor;
    this.font = font;
  }

  /**
   * gets the name of theme
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * gets the background color of the theme
   *
   * @return background color
   */
  public Color getBackgroundColor() {
    return backgroundColor;
  }

  /**
   * gets the font color of the theme
   *
   * @return font color
   */
  public Color getFontColor() {
    return fontColor;
  }

  /**
   * gets the font of the theme
   *
   * @return font
   */
  public String getFont() {
    return font;
  }
}
