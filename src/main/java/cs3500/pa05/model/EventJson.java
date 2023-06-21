package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EventJson(@JsonProperty("event") Event event) {
}
