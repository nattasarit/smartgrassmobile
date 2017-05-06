package bsd.chula.smartgrass.api.model;

import java.util.List;

/**
 * Created by Dev_Tee on 5/1/17.
 */

public class InsertResponse {

    private List<Result> mResults;

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }
}
