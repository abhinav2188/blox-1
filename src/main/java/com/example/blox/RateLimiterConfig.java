
@Configruation
public class RateLimiterConfig{

    @Bean   
    public RateLimiter rateLimiter(){
        // initialize ratelimited with 1000ms max 3 requests
        RateLimiter rateLimiter = new RateLimiter(1000,3);
        return rateLimiter;
    }



}