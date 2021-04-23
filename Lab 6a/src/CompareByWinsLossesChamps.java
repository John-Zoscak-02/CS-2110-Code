import java.util.Comparator;

public class CompareByWinsLossesChamps implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if (a.getNumberOfWins() == b.getNumberOfWins()) {
			if (a.getNumberOfLosses() == b.getNumberOfLosses()) {
				return b.getNumberOfChampionships() - a.getNumberOfChampionships();
			}
			else {
				return a.getNumberOfLosses() - b.getNumberOfLosses();
			}
		}
		return b.getNumberOfWins() - a.getNumberOfWins();
	}

}
