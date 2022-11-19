package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Bridge userThinkBridge;

    public BridgeGame(Bridge bridge) {
        this.userThinkBridge = new Bridge(new ArrayList<>());
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge.getBridge();
    }

    public List<String> getUserThinkBridge() {
        return userThinkBridge.getBridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, int step) {
        boolean isEqual = compareBridgeAndUserThink(moving, step);
        addUserThinkBridge(isEqual);
        return isEqual;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userThinkBridge.clearAll();
    }

    private boolean compareBridgeAndUserThink(String moving, int step){
        return moving.equals(bridge.getBridge().get(step));
    }

    private void addUserThinkBridge(boolean isEqual){
        if (isEqual){
            userThinkBridge.setBridge("O");
            return;
        }
        userThinkBridge.setBridge("X");
    }
}