import java.util.Date;

public class Recommendation {
    private String recommendedExercise;
    private String recommendedDiet;
    private int clinId;
    private Date recommendationDate;

    public Recommendation(String recommendedDiet, String recommendedExercise,Date recommendationDate) {
        this.recommendedDiet = recommendedDiet;
        this.recommendedExercise = recommendedExercise;
        this.recommendationDate = recommendationDate;
    }

    public String getRecommendedDiet() {
        return recommendedDiet;
    }

    public void setRecommendedDiet(String recommendedDiet) {
        this.recommendedDiet = recommendedDiet;
    }



    public String getRecommendedExercise() {
        return recommendedExercise;
    }

    public void setRecommendedExercise(String recommendedExercise) {
        this.recommendedExercise = recommendedExercise;
    }
    public int getClinId() {
        return clinId;
    }

    public void setClinId(int clinId) {
        this.clinId = clinId;
    }


}
