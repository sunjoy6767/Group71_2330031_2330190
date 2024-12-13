package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;

public class DummySetInventoryThresholds implements Serializable {
    private String Type;
    private int minimumThreshold;
    private int maximumThreshold;

    public DummySetInventoryThresholds(String type, int minimumThreshold, int maximumThreshold) {
        this.Type = type;
        this.minimumThreshold = minimumThreshold;
        this.maximumThreshold = maximumThreshold;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(int minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }

    public int getMaximumThreshold() {
        return maximumThreshold;
    }

    public void setMaximumThreshold(int maximumThreshold) {
        this.maximumThreshold = maximumThreshold;
    }

    @Override
    public String toString() {
        return "DummySetInventoryThresholds{" +
                "Type='" + Type + '\'' +
                ", minimumThreshold=" + minimumThreshold +
                ", maximumThreshold=" + maximumThreshold +
                '}';
    }
}
