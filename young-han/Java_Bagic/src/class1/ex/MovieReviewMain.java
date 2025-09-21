package class1.ex;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview l = new MovieReview();
        MovieReview p = new MovieReview();
        l.title = "Lord of the Ring";
        l.review = "good";
        p.title = "Planet of the Ape:The new age";
        p.review = "fuck";
        MovieReview[] movieReviews = new MovieReview[]{l, p};

        for(MovieReview m : movieReviews)
            System.out.println("title: " + m.title + " | review: " + m.review);

    }
}
