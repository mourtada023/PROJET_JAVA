package select;
import java.util.*;
import competitor.*;
import competition.*;

public interface Selection {


     /**
     * This method select the competitor who won.
     * @param g (A GroupeStage)
     * @return the selected Competitor
     */
    public List<Competitor> select(GroupStage g);
    
}
