package pr10_TirePressureMonitoringSystem;

public class Alarm {
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private Sensor sensor;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    private boolean alarmOn = false;

    public void check() {
        double psiPressureValue = this.sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
            alarmOn = true;
        }
    }

    public boolean getAlarmOn() {
        return this.alarmOn;
    }
}
