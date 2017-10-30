package model;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
/**
 * @author v.osepyan
 */
public class SequenceModel {
    private JsonNode sequenceJson;

    public JsonNode getSequenceJson() {
        return sequenceJson;
    }

    public SequenceModel(String sequenceString) {
        this.sequenceJson = Json.toJson(sequenceJson);
    }
}
