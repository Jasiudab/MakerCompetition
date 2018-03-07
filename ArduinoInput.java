
/*
 * class is a thread that listens for the input from the arduino
 * it only reads Serial.println bearing in mind
 * modes of this object
 * either setup, listening for highest light intensity
 * running, atm, prints if the light goes higher than the maximum
 * paused, doesnt print out anything if the event if done
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class ArduinoInput implements SerialPortEventListener {
	SerialPort serialPort;
	public static final String portName = "COM1"; // the port that the program
													// uses
	private BufferedReader input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;
	private double maximumLight;
	String mode = "setup";

	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

			if (currPortId.getName().equals(portName)) {
				portId = currPortId;
				break;
			}
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	boolean overLimit = false;
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = input.readLine();
				int inputNumber = Integer.parseInt(inputLine);
				// System.out.println(inputNumber);
				switch (mode) {
				case "setup":
					
					if (inputNumber > maximumLight && inputNumber < 2000) {
						maximumLight = inputNumber;
					}
					break;
				case "run":
					
					if (inputNumber > maximumLight + (maximumLight / 10)) {
						overLimit = true;
					}
					if(overLimit) {
						if(inputNumber <= maximumLight) {
							System.out.println("click registered");
							overLimit = false;
						}
					}
					break;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}

	public static void main(String[] args) throws Exception {

		ArduinoInput main = new ArduinoInput();
		main.initialize();
		// getting maximum light values
		main.mode = "setup";
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();
		t.join();
		System.out.println("Maximum Light: " + main.maximumLight);
		main.mode = "run";
		// run
		Thread t2 = new Thread() {
			public void run() {
				try {
					Thread.sleep(100000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t2.start();
		System.out.println(ProblemGenerator.generateMultiplicationProblem(5));
		t2.join();
		
		System.exit(0);
	}
}
