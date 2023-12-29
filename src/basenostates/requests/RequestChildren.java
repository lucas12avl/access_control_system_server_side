package basenostates.requests;
import basenostates.areaspaces.Area;
import basenostates.requests.Request;
import org.json.JSONObject;
import basenostates.areaspaces.DirectoryAreas;

public class RequestChildren implements Request{
    private final String areaId;
    private JSONObject jsonTree; // 1 level tree, root and children

    public RequestChildren(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaId() {
        return areaId;
    }

    @Override
    public JSONObject answerToJson() {
        return jsonTree;
    }

    @Override
    public String toString() {
        return "RequestChildren{areaId=" + areaId + "}";
    }

    public void process() {
        // TODO What would be the equivalent of getInstance? -- maybe is the unic instance that we have: the root area to search the area with the given areaId
        Area area;

        if (areaId.equals("root")){ //all the trees must have a root that gives the first instance bc what if we change the tree?
            area = DirectoryAreas.getInstance();
        }
        else {
            area = DirectoryAreas.getInstance().findAreaById(areaId);
        }
        jsonTree = area.toJson(1);
    }
}
