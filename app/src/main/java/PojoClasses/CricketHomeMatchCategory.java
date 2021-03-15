package PojoClasses;

public class CricketHomeMatchCategory {
    private String matchId,seriesName,team1Title,team2Title,gameFormat,timeLeft;
    private  Integer team1ImageUrl,team2ImageUrl;

    public CricketHomeMatchCategory(String matchId, String seriesName, String team1Title, String team2Title, String gameFormat, String timeLeft, Integer team1ImageUrl,Integer team2ImageUrl) {
        this.matchId = matchId;
        this.seriesName = seriesName;
        this.team1Title = team1Title;
        this.team2Title = team2Title;
        this.gameFormat = gameFormat;
        this.timeLeft = timeLeft;
        this.team1ImageUrl = team1ImageUrl;
        this.team2ImageUrl=team2ImageUrl;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getTeam1Title() {
        return team1Title;
    }

    public void setTeam1Title(String team1Title) {
        this.team1Title = team1Title;
    }

    public String getTeam2Title() {
        return team2Title;
    }

    public void setTeam2Title(String team2Title) {
        this.team2Title = team2Title;
    }

    public String getGameFormat() {
        return gameFormat;
    }

    public void setGameFormat(String gameFormat) {
        this.gameFormat = gameFormat;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }


    public Integer getTeam1ImageUrl() {
        return team1ImageUrl;
    }

    public void setTeam1ImageUrl(Integer team1ImageUrl) {
        this.team1ImageUrl = team1ImageUrl;
    }

    public Integer getTeam2ImageUrl() {
        return team2ImageUrl;
    }

    public void setTeam2ImageUrl(Integer team2ImageUrl) {
        this.team2ImageUrl = team2ImageUrl;
    }
}
