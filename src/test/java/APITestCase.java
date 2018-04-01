/* Written by Kevin Tom */

package org.threeks;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

/* Tests rely heavily on Twitter API responsiveness, which is bad for a standard
   free API key */
public class APITestCase {
    
    MyConnection conn = new MyConnection();

    @Test
    public void testHome() throws Exception {
        String name = "Twitter";
        assertNotNull(MyConnection.getResponse(
            String.format(HomeServlet.apiUrl, name)
        ));
    }

    @Test
    public void testGetFollowers() throws Exception {
        String query = "Twitter";
        assertNotNull(MyConnection.getResponse(
            String.format(GetFollowersServlet.apiUrl, query)
        ));
    }

    @Test
    public void testGetFriends() throws Exception {
        String query = "Twitter";
        assertNotNull(MyConnection.getResponse(
            String.format(GetFriendsServlet.apiUrl, query)
        ));
    }

    @Test public void testSearchTweets() throws Exception {
        String query = "Twitter";
        int count = 2;
        assertNotNull(MyConnection.getResponse(
            String.format(SearchTweetsServlet.apiUrl, query, count)
        ));
    }

    @Test
    public void testSeeFriendship() throws Exception {
        String source = "Twitter";
        String target = "TwitterDev";
        assertNotNull(MyConnection.getResponse(
            String.format(SeeFriendshipServlet.apiUrl, source, target)
        ));
    }

    @Test
    public void testTrendLocations() throws Exception {
        double lat = 37.70;
        double longi = -122.40;
        assertNotNull(MyConnection.getArrayResponse(
            String.format(TrendLocationsServlet.apiUrl, lat, longi)
        ));
    }

    @Test
    public void testUserFavorites() throws Exception {
        String name = "Twitter";
        int count = 2;
        assertNotNull(MyConnection.getArrayResponse(
            String.format(UserFavoritesServlet.apiUrl, name, count)
        ));
    }

    @Test
    public void testUserTimeline() throws Exception {
        String name = "Twitter";
        int count = 2;
        assertNotNull(MyConnection.getArrayResponse(
            String.format(UserTimelineServlet.apiUrl, name, count)
        ));
    }
   
   @Test
   public void invalidTest() throws Exception {
      assertNotNull(null);
   }
}
