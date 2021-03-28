package DataInput;

public class Shot {

	//possessions
	//players
	//result, shot, forced turnover, unforced turnover, shotclock
	//ending player 
	//total time
	//quarter
	//completed sub
	//possession 
	//number of passes
	//number of shots - calculated
	//rideback, clear, faceoff
	//number of resets
	//flag down
	
	private int shotID; //check
	private int quarterID; //check
	private int[] playerID = new int[2];
	private int[] positionID = new int[2];
	private char result; //check
	private double sX; //check
	private double sY; //check
	private String goalLoc;//check
	private char hand;//
	private String release;//
	private String type;//
	private int fake;//
	private int contested;//
	private int assist; //check
	private double aX; //check
	private double aY; //check
	
	
	private String manUp;
	private int transition;//
	
	private int year;
	private String folderName;
	private String fileName;
	
	public Shot(int shotID, int quarterID) {
		this.shotID = shotID;
		this.quarterID = quarterID;
	}
	
	public String toString() {
		return shotID + ",gameID," + playerID[0] + "," + positionID[0] + "," + quarterID + "," + "DateID" + "," + hand + ","+ result + "," + release + "," + sX + "," + sY + "," + goalLoc + "," + type + "," + assist + "," + playerID[1] + "," + positionID[1] + "," + aX + "," + aY + "," + contested + "," + manUp + "," + fake + "," + transition;
	}
	public int getShotID() {
		return shotID;
	}

	public void setShotID(int shotID) {
		this.shotID = shotID;
	}

	public char getHand() {
		return hand;
	}

	public void setHand(char hand) {
		this.hand = hand;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public double getsX() {
		return sX;
	}

	public void setsX(double sX) {
		this.sX = sX;
	}

	public double getsY() {
		return sY;
	}

	public void setsY(double sY) {
		this.sY = sY;
	}

	public String getGoalLoc() {
		return goalLoc;
	}

	public void setGoalLoc(String goalLoc) {
		this.goalLoc = goalLoc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAssist() {
		return assist == 1;
	}

	public void setAssist(boolean assist) {
		if(assist) {
			this.assist = 1;
		} else {
			this.assist = 0;
		}
	}

	public double getaX() {
		return aX;
	}

	public void setaX(double aX) {
		this.aX = aX;
	}

	public double getaY() {
		return aY;
	}

	public void setaY(double aY) {
		this.aY = aY;
	}

	public boolean isContested() {
		return contested == 1;
	}

	public void setContested(boolean contested) {
		if(contested) {
			this.contested = 1;
		} else {
			this.contested = 0;
		}
	}

	public boolean isTransition() {
		return transition == 1;
	}

	public void setTransition(boolean transition) {
		if(transition) {
			this.transition = 1;
		} else {
			this.transition = 0;
		}
	}

	public String getManUp() {
		return manUp;
	}

	public void setManUp(String manUp) {
		this.manUp = manUp;
	}

	public char getResult() {
		return result;
	}

	public void setResult(char result) {
		this.result = result;
	}
	
	public Shot(int shotID) {
		this.shotID = shotID;
	}

	public int getQuarterID() {
		return quarterID;
	}

	public void setQuarterID(int quarterID) {
		this.quarterID = quarterID;
	}

	public int getPlayerID(int i) {
		return playerID[i];
	}

	public void setPlayerID(int playerID, int i) {
		this.playerID[i] = playerID;
	}

	public int getPositionID(int i) {
		return positionID[i];
	}

	public void setPositionID(int positionID, int i) {
		this.positionID[i] = positionID;
	}

	public boolean isFake() {
		return fake == 1;
	}

	public void setFake(boolean fake) {
		if(fake) {
			this.fake = 1;
		} else {
			this.fake = 0;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

	

	
	
}
