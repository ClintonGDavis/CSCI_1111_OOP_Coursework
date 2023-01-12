package finalProject1175;

class BalancedLiving {
	private static String loveStandard = null;
	private static String workStandard = null;
	private static String learningStandard = null;
	private static String playStandard = null;
	private static String healthStandard = null;
	private static String safetyStandard = null;

	private static String loveScore = "0";
	private static String workScore = "0";
	private static String learningScore = "0";
	private static String playScore = "0";
	private static String healthScore = "0";
	private static String safetyScore = "0";
	
	BalancedLiving() {
		
	}
	
	public String getLoveStandard() {
		
		return loveStandard;
	}

	public void setLoveStandard(String loveStandard) {

		this.loveStandard = loveStandard;
	}

	public String getWorkStandard() {
		
		return workStandard;
	}

	public void setWorkStandard(String workStandard) {

		this.workStandard = workStandard;
	}
	
	public String getLearningStandard() {
		
		return learningStandard;
	}

	public void setLearningStandard(String learningStandard) {

		this.learningStandard = learningStandard;
	}
	
	public String getPlayStandard() {
		
		return playStandard;
	}

	public void setPlayStandard(String playStandard) {

		this.playStandard = playStandard;
	}
	
	public String getHealthStandard() {
		
		return healthStandard;
	}

	public void setHealthStandard(String healthStandard) {

		this.healthStandard = healthStandard;
	}
	
	public String getSafetyStandard() {
		
		return safetyStandard;
	}

	public void setSafetyStandard(String safetyStandard) {

		this.safetyStandard = safetyStandard;
	}

	public String getLoveScore() {

		return loveScore;
	}
	
	public double getLoveScoreDouble() {
		
		return Double.parseDouble(loveScore);
	}

	public void setLoveScore(String loveScore) {

		this.loveScore = loveScore;
	}

	public String getWorkScore() {

		return workScore;
	}
	
	public double getWorkScoreDouble() {
		
		return Double.parseDouble(workScore);
	}

	public void setWorkScore(String workScore) {

		this.workScore = workScore;
	}

	public String getLearningScore() {

		return learningScore;
	}
	
	public double getLearningScoreDouble() {
		
		return Double.parseDouble(learningScore);
	}

	public void setLearningScore(String learningScore) {

		this.learningScore = learningScore;
	}

	public String getPlayScore() {

		return playScore;
	}
	
	public double getPlayScoreDouble() {
		
		return Double.parseDouble(playScore);
	}

	public void setPlayScore(String playScore) {

		this.playScore = playScore;
	}

	public String getHealthScore() {

		return healthScore;
	}
	
	public double getHealthScoreDouble() {
		
		return Double.parseDouble(healthScore);
	}

	public void setHealthScore(String healthScore) {

		this.healthScore = healthScore;
	}

	public String getSafetyScore() {

		return safetyScore;
	}
	
	public double getSafetyScoreDouble() {
		
		return Double.parseDouble(safetyScore);
	}

	public void setSafetyScore(String safetyScore) {

		this.safetyScore = safetyScore;
	}

	@Override
	public String toString() {
		return "Love Standard: " + getLoveStandard()
				+ "\nLove Score: " +getLoveScore()
				+ "\n"
				+ "\nWork Standard: " + getWorkStandard()
				+ "\nWork Score: " + getWorkScore()
				+ "\n"
				+ "\nLearning Standard: " + getLearningStandard()
				+ "\nLearning Score: " + getLearningScore()
				+ "\n"
				+ "\nPlay Standard: " + getPlayStandard()
				+ "\nPlay Score: " + getPlayScore()
				+ "\n"
				+ "\nHealth Standard: " + getHealthStandard()
				+ "\nHealth Score: " + getHealthScore()
				+ "\n"
				+ "\nSafety Standard: " + getSafetyStandard()
				+ "\nSafety Score: " + getSafetyScore();
	}
}