package pr10_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AlarmTest {

    private Alarm alarm;

    @Mock
    private Sensor sensor;

    @Before
    public void initialize() {

        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(this.sensor);
    }

    @Test
    public void alarmWithLowPressureShouldActiveTheAlarm() {

        // Arrange
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(10.10);

        // Act
        this.alarm.check();

        // Assert
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void alarmWithHighPressureShouldActiveTheAlarm() {

        // Arrange
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(25.25);

        // Act
        this.alarm.check();

        // Assert
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void alarmWithMiddlePressureShouldNotActiveTheAlarm() {

        // Arrange
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(19.2);

        // Act
        this.alarm.check();

        // Assert
        Assert.assertFalse(this.alarm.getAlarmOn());
    }

    @Test
    public void check() throws Exception {

    }

    @Test
    public void getAlarmOn() throws Exception {

    }

}