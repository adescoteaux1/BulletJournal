package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TaskJson(@JsonProperty("task") Task task) {
}
