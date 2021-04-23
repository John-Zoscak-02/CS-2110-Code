import java.util.Comparator;

public class CompareByPlayoffsAndSalary implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if (a.isPlayoffTeam() == b.isPlayoffTeam()) {
			return (int)(a.getSalaryInMillions() - b.getSalaryInMillions());
		}
		else {
			if (a.isPlayoffTeam()) {
				return -1;
			}
			return 1;
		}
	}

}
