package PojoClasses;

import java.util.List;

public class UpcomingMatchesLeagueAllCategory {
    private String leagueTitle;
    private List<UpcomingMatchesLeagueCategory> leagueList;

    public UpcomingMatchesLeagueAllCategory(String leagueTitle, List<UpcomingMatchesLeagueCategory> leagueList) {
        this.leagueTitle = leagueTitle;
        this.leagueList = leagueList;
    }

    public String getLeagueTitle() {
        return leagueTitle;
    }

    public void setLeagueTitle(String leagueTitle) {
        this.leagueTitle = leagueTitle;
    }

    public List<UpcomingMatchesLeagueCategory> getLeagueList() {
        return leagueList;
    }

    public void setLeagueList(List<UpcomingMatchesLeagueCategory> leagueList) {
        this.leagueList = leagueList;
    }
}
