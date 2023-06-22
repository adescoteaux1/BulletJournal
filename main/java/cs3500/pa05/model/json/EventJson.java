package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs3500.pa05.model.Event;

public record EventJson(@JsonProperty("event") Event event) {
}
