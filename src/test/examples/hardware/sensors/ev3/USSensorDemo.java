package examples.hardware.sensors.ev3;

import ev3dev.hardware.ports.SensorPort;
import ev3dev.hardware.sensors.ev3.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lombok.extern.slf4j.Slf4j;

public @Slf4j class USSensorDemo {

	//Robot Configuration
	private static EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S1);
	
	//Configuration
	private static int HALF_SECOND = 500;
	
	public static void main(String[] args) {

		final SampleProvider sp = us1.getDistanceMode();
		int distanceValue = 0;

        //Robot control loop
        final int iteration_threshold = 20;
        for(int i = 0; i <= iteration_threshold; i++) {

        	float [] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            distanceValue = (int)sample[0];
        	
        	log.info("Iteration: ", i);
            log.info("Distance: {}", distanceValue);

            Delay.msDelay(HALF_SECOND);
        }
		
	}

}