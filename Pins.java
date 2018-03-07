
public class Pins {
	private int id;
	private int lightValue;
	private int max;
	private int codeValue;
	boolean overLimit = false;
	public  Pins(int id,int lightValue, int max,int codeValue){
		this.id = id;
		this. lightValue = lightValue;
		this.max = max;
		this.codeValue = codeValue;
	}
	public void setLightValue(int lightValue) {
		this.lightValue = lightValue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(int codeValue) {
		this.codeValue = codeValue;
	}
	public void setUp(int lightValue) {
		if (lightValue > max && lightValue < 2000) {
			max = lightValue;
		}
	}
	public void run(int lightValue) {
		if (lightValue > max + (max / 10)) {
			overLimit = true;
		}
		if(overLimit) {
			if(lightValue <= max) {
				System.out.println("click registered " + " pin " + id);
				Main.recieveInput(codeValue);
				overLimit = false;
			}
		}
	}
}
