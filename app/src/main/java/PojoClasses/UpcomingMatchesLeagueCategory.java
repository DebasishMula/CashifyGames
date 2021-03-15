package PojoClasses;

public class UpcomingMatchesLeagueCategory {
    private  String leagueId,winningAmount,entryAmount,teamLeft,teamTotal,noOfJoin,entryFormat,totalWinners;

    public UpcomingMatchesLeagueCategory(String leagueId, String winningAmount, String entryAmount, String teamLeft, String teamTotal, String noOfJoin, String entryFormat, String totalWinners) {
        this.leagueId = leagueId;
        this.winningAmount = winningAmount;
        this.entryAmount = entryAmount;
        this.teamLeft = teamLeft;
        this.teamTotal = teamTotal;
        this.noOfJoin = noOfJoin;
        this.entryFormat = entryFormat;
        this.totalWinners = totalWinners;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(String winningAmount) {
        this.winningAmount = winningAmount;
    }

    public String getTotalAmount() {
        return entryAmount;
    }

    public void setTotalAmount(String entryAmount) {
        this.entryAmount = entryAmount;
    }

    public String getTeamLeft() {
        return teamLeft;
    }

    public void setTeamLeft(String teamLeft) {
        this.teamLeft = teamLeft;
    }

    public String getTeamTotal() {
        return teamTotal;
    }

    public void setTeamTotal(String teamTotal) {
        this.teamTotal = teamTotal;
    }

    public String getNoOfJoin() {
        return noOfJoin;
    }

    public void setNoOfJoin(String noOfJoin) {
        this.noOfJoin = noOfJoin;
    }

    public String getEntryFormat() {
        return entryFormat;
    }

    public void setEntryFormat(String entryFormat) {
        this.entryFormat = entryFormat;
    }

    public String getTotalWinners() {
        return totalWinners;
    }

    public void setTotalWinners(String totalWinners) {
        this.totalWinners = totalWinners;
    }

    public String getEntryAmount() {
        return entryAmount;
    }

    public void setEntryAmount(String entryAmount) {
        this.entryAmount = entryAmount;
    }
}
