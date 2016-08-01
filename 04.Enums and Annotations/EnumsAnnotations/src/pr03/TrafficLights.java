package pr03;

public enum TrafficLights {

    RED,
    GREEN,
    YELLOW;

    private static TrafficLights[] lights = TrafficLights.values();

    public TrafficLights next() {
        return lights[(this.ordinal() + 1) % lights.length];
    }
}
