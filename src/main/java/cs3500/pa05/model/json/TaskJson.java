package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Task;

/**
 * placeholder for task
 *
 * @param task represents a task
 */
public record TaskJson(@JsonProperty("task") Task task) {
}
