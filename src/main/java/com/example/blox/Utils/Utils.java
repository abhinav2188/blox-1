
@Component
public class Utils{


    @Autowired
    private RateLimiter rateLimiter;

    public boolean isApiCallAllowed(String username){
        // we are using global rate limiter for now. i.e. no user level rate limit is done
        // using username we can apply user level api rate limiting

        if(rateLimiter.acquire()){
            return true;
        }else{
            throw new RateLimiterAccquireException();
        }

        return false;


    }


}