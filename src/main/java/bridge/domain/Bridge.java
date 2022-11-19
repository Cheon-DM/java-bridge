package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(String component){
        bridge.add(component);
    }

    public void clearAll(){
        bridge.clear();
    }
}