package model;

public class Job {
	protected int jobID;
	protected String jobName;
	protected String category;
	protected int levelCap;

    public Job(int jobID, String jobName, String category, int levelCap) {
        this.jobID = jobID;
        this.jobName = jobName;
        this.category = category;
        this.levelCap = levelCap;
    }

    public Job(String jobName, String category, int levelCap) {
        this.jobName = jobName;
        this.category = category;
        this.levelCap = levelCap;
    }

    public Job(int jobID) {
        this.jobID = jobID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLevelCap() {
        return levelCap;
    }

    public void setLevelCap(int levelCap) {
        this.levelCap = levelCap;
    }
}
